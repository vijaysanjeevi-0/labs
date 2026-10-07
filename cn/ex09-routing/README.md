# Ex 9 — Distance Vector and Link State routing in NS2

**Aim:** Simulate Distance Vector and Link State routing protocols using NS2.

## Concepts
| | Distance Vector | Link State |
|--|-----------------|-----------|
| Algorithm | Bellman-Ford | Dijkstra |
| Shares | its routing table with neighbours only | link status with *all* routers (flooding) |
| Knowledge | direction and distance ("routing by rumour") | full topology map |
| Examples | RIP, IGRP | OSPF, IS-IS |
| Issue | count-to-infinity | more memory/CPU and overhead |

## Algorithm
1. Create a simulator object.
2. Set the routing protocol (`rtproto LS` or `rtproto DV`).
3. Open the NAM and trace files.
4. Define the `finish` procedure.
5. Create the nodes (7-node ring for LS, 8-node octagon for DV) and connect them in a ring with 1 Mb, 10 ms links.
6. Attach a UDP agent to the source and CBR traffic on top (packetSize 500, interval 0.005).
7. Attach a Null agent to the destination and connect source to sink.
8. Schedule events: start traffic at 0.5 s; take a link down at 1.0 s; bring it up at 2.0 s; stop traffic at 4.5 s; finish at 5.0 s.
9. Run, then watch in NAM how traffic reroutes the long way round while the link is down.

## Run
```bash
ns linkstate.tcl && nam linkstate.nam      # link 1-2 down 1-2 s, traffic n0 -> n3
ns distvect.tcl  && nam -a out.nam         # link n3-n4 down 1-2 s, traffic n1 -> n4
```

## What was fixed
`proc finish {}` followed by `{` on a new line is a Tcl syntax error. The `finish` procedure is replaced by one scheduled `flush-trace; exit` line, and the nodes and links are created with loops. `distvect.tcl` still writes `trace.tr` for the trace-file analysis step.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
