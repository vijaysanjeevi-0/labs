# Ex 5 — Capture and examine packets with Wireshark

**Aim:** Use Wireshark to capture packets and examine them.

## Procedure
1. Open Wireshark.
2. Choose the interface (e.g. `eth0`, `Wi-Fi`) and optionally set a *capture filter* (e.g. `host 8.8.8.8`).
3. Start capturing: click the shark-fin button, or **Capture → Start**, or `Ctrl+E`.
4. Generate traffic: open a website, `ping 8.8.8.8`, `nslookup example.com`, or `traceroute`.
5. Stop the capture (`Ctrl+E` again).
6. Apply a *display filter* and inspect the packets.

## The three panes
| Pane | Shows |
|------|-------|
| Packet List (top) | One row per packet: No., Time, Source, Destination, Protocol, Length, Info |
| Packet Details (middle) | Decoded layers (Frame, Ethernet, IP, TCP/UDP, application). Right-click a field to build a filter |
| Packet Bytes (bottom) | Raw packet in hexadecimal |

Right-click a packet → **Follow → TCP Stream** to see one whole conversation.

## Handy display filters
```
icmp                    ping / traceroute
dns                     DNS queries and responses
tcp.port == 80          HTTP traffic
ip.addr == 192.168.1.5  everything to or from one host
arp                     ARP requests/replies
tcp.flags.syn == 1      TCP connection attempts
```

## Things to note in your observation
- ICMP Echo Request (type 8) followed by Echo Reply (type 0) for ping.
- ICMP Time Exceeded (type 11) from each router during traceroute.
- The TCP 3-way handshake (SYN, SYN-ACK, ACK) when opening a site.
- DNS query and response before the first HTTP packet.

Take screenshots of the packet list and the details pane for your record.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
