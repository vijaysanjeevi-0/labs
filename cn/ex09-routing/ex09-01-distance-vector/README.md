# Ex 9.1 — Distance Vector routing (NS2)

**Aim:** Simulate Distance Vector routing (Bellman-Ford, RIP/IGRP-style) using NS2.

## Topology
8-node ring (octagon), each link 1 Mb / 10 ms. Traffic flows n0 → n3; link n2–n3 is cut mid-simulation, forcing traffic the long way round.

```
                n0 ---- n1
               /            \
             n7              n2
              |                |
             n6              n3  <-- CBR traffic n0 -> n3
               \            /       (link n2-n3 cut 1.0-2.0s)
                n5 ---- n4
```

## Algorithm
1. Create a simulator object, set `rtproto DV`.
2. Open NAM/trace files.
3. Create 8 nodes n0–n7 and link each to the next, wrapping around (ring).
4. Attach a UDP agent + CBR traffic (packetSize 500, interval 0.005) from n0 to sink n3.
5. Schedule: traffic starts 0.5 s; link n2–n3 goes down at 1.0 s, back up at 2.0 s; finish at 5.0 s.
6. Run, then watch in NAM how traffic reroutes the long way round the ring while the link is down.

```bash
ns distvect.tcl
nam -a out.nam
```

**Expected output:** `out.nam` shows traffic flowing n0→n3 directly (one hop via n1→n2→n3 or n7→...), rerouting the long way round (n0→n7→n6→n5→n4→n3) during the 1–2 s outage, then returning to the direct path once the link is restored.

## What was fixed
`proc finish {}` followed by `{` on a new line was a Tcl syntax error. Replaced by one scheduled `flush-trace; exit` line; nodes/links built with loops. Still writes `trace.tr` for later analysis.
