# ex07 - Hadoop WordCount

## Aim
Install a single-node Hadoop cluster and run WordCount.

## Build & run
```
ant jar
bin/hadoop jar jar/wc.jar WordCount /input /output
bin/hadoop fs -cat /output/part-r-00000
```

## Output
```
word1   3
word2   1
...
```
One `<word> <tab> <count>` line per distinct word in the input.
