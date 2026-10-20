# Ex 9.2 — Link State routing (NS2)

**Aim:** Simulate Link State routing (Dijkstra, OSPF/IS-IS-style) using NS2.

## Topology
7-node ring, each link 1 Mb / 10 ms. Traffic flows n0 → n3; link n1–n2 is cut mid-simulation.

```
          n0 ---- n1
         /            \
       n6              n2   <-- link n1-n2 cut 1.0-2.0s
        |                |
       n5              n3  <-- CBR traffic n0 -> n3
         \            /
              n4
```

## Algorithm
1. Create a simulator object, set `rtproto LS`.
2. Open the NAM trace file.
3. Create 7 nodes n0–n6 and link each to the next, wrapping around (ring).
4. Attach a UDP agent + CBR traffic (packetSize 500, interval 0.005) from n0 to sink n3.
5. Schedule: traffic starts 0.5 s; link n1–n2 goes down at 1.0 s, back up at 2.0 s; finish at 5.0 s.
6. Run, then watch in NAM how traffic reroutes the long way round the ring while the link is down.

```bash
ns linkstate.tcl
nam linkstate.nam
```

**Expected output:** `linkstate.nam` shows traffic flowing n0→n3 the short way (n0→n1→n2→n3), rerouting the long way (n0→n6→n5→n4→n3) during the 1–2 s outage, then returning to the direct path.

## What was fixed
Same `proc finish {}` syntax issue as the distance-vector script, fixed the same way (scheduled `flush-trace; exit`, loop-built nodes/links).
