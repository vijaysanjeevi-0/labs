# Ex 1 viva — network commands

1. **What does ping do?** Sends ICMP Echo Requests and waits for Echo Replies to test reachability and round-trip time.
2. **Which protocol does ping use?** ICMP (no port number, no TCP/UDP).
3. **How does traceroute work?** It sends packets with TTL 1, 2, 3... Each router drops the packet at TTL 0 and returns ICMP Time Exceeded, revealing the path.
4. **traceroute vs tracert?** Same tool: `traceroute` on Linux/macOS (UDP probes by default), `tracert` on Windows (ICMP echo).
5. **What does `* * *` or "Request timed out" mean?** No reply: the host is down, a firewall drops ICMP, or the path is broken.
6. **What does netstat show?** Active connections, listening ports, routing table and protocol statistics (`-a` all, `-n` numeric, `-t` TCP, `-r` routes).
7. **ifconfig vs ipconfig?** `ifconfig` (Linux/macOS) and `ipconfig` (Windows) show the IP, mask and gateway of each interface. `ip addr` replaces ifconfig on modern Linux.
8. **What does nslookup do?** Queries a DNS server to translate a domain name to an IP (or the reverse).
9. **What does tcpdump do?** Command-line packet sniffer that captures packets on an interface using filters.
10. **Example tcpdump filters?** `host`, `src host`, `dst host`, `tcp`, `icmp`, `src port 21`, `dst port 80`.
11. **What is promiscuous mode?** The NIC accepts all frames it sees, not only those addressed to it.
12. **Why was the ping in the manual 100% lost?** 172.16.6.2 is a private address that was unreachable from that network.
13. **What is TTL?** Maximum hop count; decremented by each router, packet discarded at 0 (prevents loops).
