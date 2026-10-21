# Ex 5 — Capture and examine packets with Wireshark

**Aim:** Use Wireshark to capture packets and examine them.

**Apparatus / Tools required:** Wireshark (or `tcpdump`), a network interface with traffic to observe.

**Algorithm / Procedure**
1. Open Wireshark, choose the interface (e.g. `eth0`, `Wi-Fi`), optionally set a capture filter (e.g. `host 8.8.8.8`).
2. Start capturing: click the shark-fin button, **Capture -> Start**, or `Ctrl+E`.
3. Generate traffic: open a website, `ping 8.8.8.8`, `nslookup example.com`, or `traceroute`.
4. Stop the capture (`Ctrl+E` again).
5. Apply a display filter and inspect the packets in the three panes (Packet List, Packet Details, Packet Bytes).
6. Right-click a packet -> Follow -> TCP Stream to see one whole conversation.

**Program:** No program — Wireshark GUI only.

**Handy display filters**
```
icmp                    ping / traceroute
dns                      DNS queries and responses
tcp.port == 80           HTTP traffic
ip.addr == 192.168.1.5   everything to or from one host
arp                      ARP requests/replies
tcp.flags.syn == 1       TCP connection attempts
```

**Sample Output:** ICMP Echo Request/Reply for ping; ICMP Time Exceeded from each router during traceroute; the TCP 3-way handshake (SYN, SYN-ACK, ACK) when opening a site; a DNS query/response before the first HTTP packet.

**Result:** Packets were captured with Wireshark and examined successfully, identifying ICMP, DNS and TCP handshake traffic.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
