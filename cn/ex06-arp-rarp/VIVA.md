# Ex 6 viva — ARP / RARP

1. **Main purpose of ARP?** Map an IPv4 (logical) address to a MAC (physical) address on the local network.
2. **How does ARP work?** The host broadcasts "who has IP x?"; the owner replies (unicast) with its MAC; the answer is stored in the ARP cache (`arp -a`).
3. **What is MTU?** Largest packet (in bytes) a link can carry without fragmentation (1500 for Ethernet).
4. **What is multiplexing?** Combining several data streams over one channel (ports let many applications share one IP).
5. **What does TTL show?** Maximum hops a packet may travel; each router decrements it and discards the packet at 0.
6. **Which layer is ARP?** Between layer 2 and 3 (Data Link / Network boundary).
7. **Function of RARP?** A host that knows its MAC asks for its IP address.
8. **ARP vs RARP?** ARP maps IP → MAC. RARP maps MAC → IP.
9. **Why was RARP replaced?** It only returns an IP and needs a server on every LAN; BOOTP and DHCP also provide mask, gateway and DNS and work across routers.
10. **How big is a MAC address?** 48 bits (6 bytes). The manual's sample values are 4 bytes for simplicity.
11. **What is ARP spoofing?** An attacker sends fake ARP replies to redirect traffic (man-in-the-middle). ARP has no authentication.
12. **What is proxy ARP / gratuitous ARP?** Proxy: a router answers ARP for another network's host. Gratuitous: a host announces its own IP/MAC (detects duplicates, updates caches).
13. **Why does the program use TCP for ARP and UDP for RARP?** Only for demonstration. Real ARP and RARP are layer-2/3 protocols with no TCP or UDP.
