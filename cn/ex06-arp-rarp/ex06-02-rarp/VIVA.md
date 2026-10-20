# Ex 6.2 viva — RARP

1. **Function of RARP?** A host that knows only its MAC asks the network for its IP address.
2. **ARP vs RARP?** ARP maps IP → MAC; RARP maps MAC → IP.
3. **Why was RARP replaced?** It only returns an IP and needs a server on every LAN; BOOTP and DHCP also return mask, gateway and DNS and work across routers.
4. **How big is a real MAC address?** 48 bits (6 bytes); the manual's sample values are 4 bytes for simplicity.
5. **Why does this program use UDP?** Matches the manual; real RARP is also a broadcast layer-2/3 protocol, not application-level UDP.
