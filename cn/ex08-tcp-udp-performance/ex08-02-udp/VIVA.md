# Ex 8.2 viva — UDP performance

1. **What is CBR?** Constant Bit Rate traffic: fixed-size packets sent at a fixed interval, used to generate predictable UDP load.
2. **What is a Null agent?** A traffic sink that silently discards whatever it receives — the UDP receiver here.
3. **Why does UDP show packet loss with no retransmission?** Nothing in UDP detects or recovers lost datagrams; a dropped packet is simply gone.
4. **What happens if UDP and TCP share a bottleneck link?** UDP does not back off under congestion, so it can starve competing TCP flows (the fairness problem).
5. **When is UDP preferred over TCP?** VoIP, video streaming, DNS, games — timely delivery matters more than guaranteed delivery.
