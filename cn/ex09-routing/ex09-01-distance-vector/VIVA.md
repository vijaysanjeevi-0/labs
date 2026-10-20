# Ex 9.1 viva — Distance Vector routing

1. **Distance Vector idea?** Each router tells its neighbours its distance to every destination; computed with Bellman-Ford. Examples: RIP, IGRP.
2. **Why is it called "routing by rumour"?** A router trusts what its neighbours report without independently verifying it.
3. **What is count-to-infinity?** After a failure, routers keep inflating the distance to the dead destination by learning stale info from each other.
4. **How is count-to-infinity fixed?** Split horizon, poison reverse, hold-down timers, and a maximum metric (RIP treats 16 as infinity).
5. **RIP's metric and hop limit?** Hop count, with a maximum of 15 hops.
