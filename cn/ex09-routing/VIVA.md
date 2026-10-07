# Ex 9 viva — Distance Vector and Link State routing

1. **Routing vs forwarding?** Routing builds the routing table (decides paths). Forwarding moves each packet to the next hop using that table.
2. **Distance Vector idea?** Each router tells its neighbours its distance to every destination; uses Bellman-Ford. Examples: RIP, IGRP.
3. **Link State idea?** Each router floods its link status to all routers, builds the full topology map, and runs Dijkstra. Examples: OSPF, IS-IS.
4. **DV vs LS?** DV: neighbours only, less memory/CPU, slow convergence, count-to-infinity. LS: whole network, faster convergence, more overhead.
5. **Why "routing by rumour"?** DV routers trust what neighbours say without knowing if it is true.
6. **What is count-to-infinity?** After a failure, routers keep increasing the distance to the dead destination by learning from each other. Fixes: split horizon, poison reverse, hold-down timers, maximum metric (RIP: 16 = infinity).
7. **RIP metric and limit?** Hop count; maximum 15 hops.
8. **OSPF metric?** Cost, based on link bandwidth.
9. **What is flooding?** Sending an incoming packet on every link except the one it arrived on; used by link-state protocols to spread LSAs.
10. **What is convergence?** All routers agreeing on consistent routes after a change.
11. **What happens in the simulation at 1 s?** The link goes down, routing updates propagate, and traffic is rerouted the long way round the ring; at 2 s the link returns.
12. **Route selection order?** Longest prefix match, then lowest metric (same protocol), then lowest administrative distance (between protocols).
13. **IGP vs EGP?** IGP routes inside an autonomous system (RIP, OSPF). EGP routes between them (BGP, a path-vector protocol).
14. **Which NS2 commands are used?** `rtproto LS` / `rtproto DV` select the protocol; `rtmodel-at ... down/up` fail and restore a link.
