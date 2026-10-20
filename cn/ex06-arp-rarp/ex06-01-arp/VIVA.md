# Ex 6.1 viva — ARP

1. **Main purpose of ARP?** Map an IPv4 (logical) address to a MAC (physical) address on the local network.
2. **How does ARP work?** The host broadcasts "who has IP x?"; the owner replies (unicast) with its MAC; the answer is cached (`arp -a`).
3. **Which layer is ARP?** Between layer 2 and 3 (Data Link / Network boundary).
4. **What is ARP spoofing?** An attacker sends fake ARP replies to redirect traffic (man-in-the-middle); ARP has no authentication.
5. **Why does this program use TCP?** Only for demonstration — real ARP is a layer-2/3 broadcast protocol, not TCP.
