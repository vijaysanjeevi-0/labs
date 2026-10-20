# Ex 8.1 viva — TCP performance

1. **What is TCPSink?** The TCP receiver agent that generates ACKs back to the sender.
2. **How is throughput calculated here?** Total bits received / duration (`throughput.awk` computes this from the trace file).
3. **Why is measured TCP throughput a bit below the link rate?** Header and ACK overhead, plus TCP slow start at the beginning of the flow.
4. **What does the FTP application do?** Generates a bulk (greedy) transfer over the TCP agent, keeping the connection saturated.
5. **What are the link parameters in the script?** 5 Mb/2 ms access links into a 1.5 Mb/10 ms bottleneck link.
