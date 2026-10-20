# Ex 9 — Distance Vector and Link State routing

**Aim:** Simulate both routing algorithms in NS2 and compare them.

| Folder | Program |
|---|---|
| `ex09-01-distance-vector/` | Distance Vector (Bellman-Ford) simulation |
| `ex09-02-link-state/` | Link State (Dijkstra) simulation |

Each has its own `README.md` and `VIVA.md`.

## Concepts
| | Distance Vector | Link State |
|--|-----------------|-----------|
| Algorithm | Bellman-Ford | Dijkstra |
| Shares | its routing table with neighbours only | link status with *all* routers (flooding) |
| Knowledge | direction and distance ("routing by rumour") | full topology map |
| Examples | RIP, IGRP | OSPF, IS-IS |
| Issue | count-to-infinity | more memory/CPU and overhead |

## Shared general questions
Routing vs forwarding, route selection order, IGP vs EGP, and the NS2 `rtmodel-at` command are covered in the [base VIVA.md](../VIVA.md).
