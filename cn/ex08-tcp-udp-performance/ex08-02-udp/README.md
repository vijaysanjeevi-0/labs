# Ex 8.2 — UDP performance (NS2)

**Aim:** Simulate UDP traffic in NS2 and measure its throughput/loss.

## Topology
Same dumbbell as the TCP test: n0 and n1 feed into n2 at 5 Mb each; n2–n3 is the 1.5 Mb bottleneck. Two CBR/UDP flows both sink at n1: n0 → n1 and n3 → n1.

```
n0 --5Mb,2ms--\                               CBR flow 1: n0 -> n1
                n2 ====1.5Mb,10ms(bottleneck)==== n3
n1 --5Mb,2ms--/        ^
   ^              CBR flow 2: n3 -> n1
   both flows sink here
```

## Algorithm
1. Create a simulator object; open trace and NAM files.
2. Create nodes n0–n3 and the same links as the TCP case.
3. Create two UDP agents (on n0 and n3) and two Null agents (on n1) as sinks; connect each UDP agent to a Null agent.
4. Attach CBR (constant bit rate) traffic to each UDP agent.
5. Start the CBR sources at 1.0 s and 1.1 s, finish at 3.0 s, run.

```bash
ns udp.tcl
nam udpout.nam
awk -v node=1 -v dur=2 -f throughput.awk udpout.tr     # node 1 receives both UDP flows
```

**Expected output:** throughput close to the CBR send rate, with any loss shown by `throughput.awk` once the link is saturated.
