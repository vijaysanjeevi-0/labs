# General viva questions (all exercises)

Exercise-specific questions are in the `VIVA.md` inside each exercise folder.

## Models and layers
1. **OSI layers?** Physical, Data Link, Network, Transport, Session, Presentation, Application.
2. **TCP/IP layers?** Link, Internet, Transport, Application (4 layers).
3. **Protocol examples per layer?** Application: HTTP, DNS, FTP, SMTP. Transport: TCP, UDP. Network: IP, ICMP. Data Link: Ethernet, ARP.
4. **What is a protocol?** A set of rules for formatting and exchanging messages.
5. **What is encapsulation?** Each layer adds its own header to the data from the layer above (segment → packet → frame).
6. **PDU names?** Segment (TCP) / datagram (UDP) at transport, packet at network, frame at data link, bits at physical.

## Addressing
7. **IP vs MAC address?** IP is a logical, hierarchical, changeable network address (32-bit IPv4, 128-bit IPv6). MAC is a physical 48-bit address burned into the NIC and used on the local link.
8. **What is a port number?** A 16-bit number identifying a process on a host (0-65535). Together with the IP it forms a socket address.
9. **Well-known ports?** HTTP 80, HTTPS 443, FTP 21, SSH 22, Telnet 23, SMTP 25, DNS 53, DHCP 67/68.
10. **Private IPv4 ranges?** 10.0.0.0/8, 172.16.0.0/12, 192.168.0.0/16.
11. **What is a subnet mask?** Splits an IP into network and host parts (e.g. 255.255.255.0 = /24).
12. **What is NAT?** Translating private addresses to a public one at the router so many hosts share one public IP.
13. **What is DHCP?** Automatically assigns IP address, mask, gateway and DNS to hosts.

## Transport
14. **TCP vs UDP?** TCP is connection-oriented, reliable, ordered, with flow and congestion control. UDP is connectionless, unreliable and lightweight.
15. **TCP three-way handshake?** SYN → SYN-ACK → ACK.
16. **Flow control vs congestion control?** Flow control protects the receiver (receiver window). Congestion control protects the network (congestion window).
17. **What is a socket?** An endpoint of a two-way communication link, identified by IP + port + protocol.
18. **Client-server vs peer-to-peer?** In client-server one machine serves many clients. In P2P every node is both client and server.

## Devices
19. **Hub vs switch vs router?** Hub repeats bits to all ports (layer 1). Switch forwards frames by MAC (layer 2). Router forwards packets by IP between networks (layer 3).
20. **What is a gateway?** The router a host uses to reach other networks.
21. **What is a firewall?** A filter that allows or blocks traffic by rules (IP, port, protocol).

## Performance
22. **Bandwidth vs throughput vs latency?** Bandwidth is the link capacity, throughput is the rate actually achieved, latency is the delay a packet experiences.
23. **Sources of delay?** Processing, queuing, transmission and propagation delay.
24. **Packet vs circuit switching?** Circuit: dedicated path reserved for the call. Packet: data split into packets that share links.

## Errors and tools
25. **Error detection vs correction?** Detection (parity, checksum, CRC) only finds errors. Correction (Hamming) also fixes them.
26. **What is ICMP used for?** Error and diagnostic messages (ping, traceroute, "destination unreachable").
27. **What is a network simulator and why use one?** Software that models a network; cheaper, faster and more repeatable than a real test bed (e.g. NS2).
28. **Java classes for TCP and UDP?** TCP: `Socket`, `ServerSocket`. UDP: `DatagramSocket`, `DatagramPacket`.

## Routing
29. **Routing vs forwarding?** Routing builds the routing table (decides paths); forwarding moves each packet to the next hop using that table.
30. **Route selection order?** Longest prefix match, then lowest metric (within a protocol), then lowest administrative distance (between protocols).
31. **IGP vs EGP?** IGP routes inside one autonomous system (RIP, OSPF); EGP routes between autonomous systems (BGP, a path-vector protocol).
32. **Which NS2 command fails/restores a link?** `rtmodel-at <time> down|up <node1> <node2>`.
