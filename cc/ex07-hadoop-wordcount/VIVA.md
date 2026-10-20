# ex07 viva — Hadoop WordCount

1. **What does the Mapper do in WordCount?** Splits each line into words and emits `(word, 1)` for every occurrence.
2. **What does the Reducer do?** Sums the counts for each key (word) and emits `(word, total_count)`.
3. **What is a Combiner, and why reuse the Reducer as one here?** A local pre-reduce step on the mapper's output to cut network traffic; since summing is associative, the same reducer logic works as a combiner.
4. **What is HDFS?** Hadoop Distributed File System — splits files into blocks replicated across the cluster for fault tolerance.
5. **Why does `main` configure `Job` instead of calling map/reduce directly?** Hadoop needs a `Job` description (classes, I/O paths, key/value types) to schedule and run the distributed task.
