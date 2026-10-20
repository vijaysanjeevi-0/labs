# Ex 9.2 viva — Link State routing

1. **Link State idea?** Each router floods its link status to every other router, builds a full topology map, and runs Dijkstra. Examples: OSPF, IS-IS.
2. **What is flooding?** Sending an incoming packet (here, a link-state advertisement) out every link except the one it arrived on.
3. **OSPF's metric?** Cost, typically derived from link bandwidth.
4. **DV vs LS trade-off?** LS converges faster and avoids count-to-infinity, but needs more memory/CPU and generates more control traffic than DV.
5. **What is convergence?** The point at which all routers agree on consistent, up-to-date routes after a topology change.
