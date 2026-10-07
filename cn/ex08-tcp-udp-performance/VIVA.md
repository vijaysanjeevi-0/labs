# Ex 8 viva — TCP/UDP performance

1. **TCP vs UDP?** TCP is reliable, ordered, connection-oriented, with flow and congestion control. UDP is unreliable, connectionless and has no congestion control.
2. **When is UDP preferred?** VoIP, video streaming, DNS, games: timely delivery matters more than reliability.
3. **What is CBR?** Constant Bit Rate traffic source: fixed packet size sent at a fixed interval.
4. **What is a Null agent?** A traffic sink that discards whatever it receives (the UDP receiver).
5. **What is TCPSink?** The TCP receiver that generates ACKs.
6. **How is throughput calculated?** Total bits received / time (`throughput.awk` does this from the trace file).
7. **Why is TCP throughput a bit below the link rate?** Headers, ACK overhead and slow start.
8. **What happens if UDP and TCP share a bottleneck?** UDP doesn't back off, so it can starve TCP flows. This is the fairness problem.
9. **Why does UDP show packet loss without retransmission?** Nothing detects or recovers lost datagrams.
10. **What are the link parameters in the script?** 5 Mb / 2 ms access links and a 1.5 Mb / 10 ms bottleneck.
11. **What is bandwidth-delay product?** Bandwidth × RTT: the amount of data in flight needed to keep the link busy.
12. **What does the FTP application do?** Generates a bulk transfer over the TCP agent.
