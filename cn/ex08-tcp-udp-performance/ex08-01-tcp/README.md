# Ex 8.1 — TCP performance (NS2)

**Aim:** Simulate TCP traffic in NS2 and measure its throughput.

## Topology
Dumbbell: n0 and n1 feed into n2 at 5 Mb each; n2–n3 is the 1.5 Mb bottleneck link. The TCP flow runs n1 → n3.

```
n0 --5Mb,2ms--\
                n2 ====1.5Mb,10ms(bottleneck)==== n3
n1 --5Mb,2ms--/        ^
                  TCP flow: n1 -> n3
```

## Algorithm
1. Create a simulator object; open trace and NAM files.
2. Create nodes n0–n3 and links (n0–n2, n1–n2 at 5 Mb; n2–n3 at 1.5 Mb bottleneck).
3. Create a TCP agent on n1 and a TCPSink on n3; connect them.
4. Attach an FTP application to the TCP agent.
5. Start FTP at 0.2 s, end the simulation at 3.0 s, run.

```bash
ns tcp.tcl
nam tcpout.nam
awk -v node=3 -v dur=2.8 -f throughput.awk tcpout.tr   # throughput and drops at node 3
```

**Expected output:** ~1.46 Mbps throughput, close to filling the 1.5 Mb bottleneck link.

## What was fixed
The manual detached the TCP agents at 1.35 s, so only 0.15 s of data flowed; FTP now runs until 3.0 s. Removed `xgraph tcpout.tr`, which cannot plot a raw trace file — use `throughput.awk` for numbers instead.
