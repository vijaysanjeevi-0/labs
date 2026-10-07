# Ex 5 viva — Wireshark

1. **What is Wireshark?** A GUI packet analyzer that captures and decodes network traffic.
2. **Capture filter vs display filter?** Capture filters (BPF syntax, e.g. `host 1.2.3.4`) limit what is recorded. Display filters (e.g. `tcp.port == 80`) hide packets already captured.
3. **The three panes?** Packet List, Packet Details (decoded layers), Packet Bytes (hex).
4. **What is promiscuous mode?** The NIC captures all frames on the segment, not just its own.
5. **What does "Follow TCP Stream" do?** Reassembles and shows one whole conversation.
6. **How do you see the TCP handshake?** Filter `tcp.flags.syn == 1` and look for SYN, SYN-ACK, ACK.
7. **How do you view ping packets?** Filter `icmp`: Echo Request (type 8), Echo Reply (type 0).
8. **Wireshark vs tcpdump?** Same libpcap capture engine; tcpdump is command-line, Wireshark has a GUI and deeper dissectors.
9. **Why can't you read HTTPS content?** The payload is encrypted with TLS; only headers of the lower layers are visible.
10. **What file format does it save?** `.pcap` / `.pcapng`.
11. **Ethical point?** Capture only on networks you own or have permission to monitor.
