# Ex 7 — Hadoop single-node cluster: WordCount

**Aim:** To install a Hadoop single-node cluster and run a simple application (WordCount) on it.

**Apparatus / Tools required:** Ubuntu, JDK 1.8, Hadoop 2.7.x, `ant`, SSH configured for localhost.

**Algorithm (WordCount)**
1. **Map:** split each input line into words; emit `(word, 1)` for every occurrence.
2. **Combine/Reduce:** sum the counts per word.
3. Write `(word, total_count)` pairs to the output directory.

**Procedure**
```bash
# one-time setup (JDK, passwordless SSH, Hadoop extracted to /opt, core-site.xml /
# hdfs-site.xml / mapred-site.xml / yarn-site.xml configured) -- see the manual for
# the full single-node install steps.
bin/hadoop namenode -format
sbin/start-dfs.sh
sbin/start-yarn.sh
jps                                        # confirm NameNode/DataNode/ResourceManager are up

# build and run WordCount
ant jar
bin/hdfs dfs -mkdir -p /user/input
bin/hdfs dfs -put input.txt /user/input
bin/hadoop jar jar/wc.jar WordCount /user/input /user/output
bin/hdfs dfs -cat /user/output/part-r-00000
```

**Program**

`WordCount.java`
```java
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }

    public static class IntSumReducer
            extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
```

`build.xml`
```xml
<project name="hadoopCompile" default="jar" basedir=".">
  <target name="init">
    <property name="sourceDir" value="."/>
    <property name="outputDir" value="classes"/>
    <property name="buildDir" value="jar"/>
    <property name="lib.dir" value="/usr/lib/hadoop"/>
    <path id="classpath">
      <fileset dir="${lib.dir}" includes="**/*.jar"/>
    </path>
  </target>
  <target name="clean" depends="init">
    <delete dir="${outputDir}"/>
    <delete dir="${buildDir}"/>
  </target>
  <target name="prepare" depends="clean">
    <mkdir dir="${outputDir}"/>
    <mkdir dir="${buildDir}"/>
  </target>
  <target name="compile" depends="prepare">
    <javac srcdir="${sourceDir}" destdir="${outputDir}" classpathref="classpath"/>
  </target>
  <target name="jar" depends="compile">
    <jar destfile="${buildDir}/wc.jar" basedir="${outputDir}">
      <manifest>
        <attribute name="Main-Class" value="WordCount"/>
      </manifest>
    </jar>
  </target>
</project>
```

**Sample Output**
```
word1   3
word2   1
...
```
One `<word><tab><count>` line per distinct word in the input.

**Result:** A single-node Hadoop cluster was installed and the WordCount MapReduce application was run successfully.
