# Ex 1 — Network commands

**Aim:** Learn tcpdump, netstat, ifconfig/ipconfig, nslookup, traceroute and ping, and capture ping/traceroute PDUs with a protocol analyzer.

**Apparatus / Tools required:** A Linux (or Windows) terminal with `ifconfig`/`ip`, `netstat`, `nslookup`, `ping`, `traceroute`/`tracert`; `tcpdump` or Wireshark for packet capture.

**Algorithm**
1. Check the interface configuration (`ifconfig` / `ipconfig`).
2. List active connections and listening ports (`netstat`).
3. Resolve a domain name with `nslookup`.
4. Test reachability with `ping`.
5. Trace the route with `traceroute` (Linux/macOS) or `tracert` (Windows).
6. In a second terminal run `tcpdump`, or start Wireshark, while repeating steps 4-5 to capture the ICMP packets.
7. Examine the captured ICMP Echo Request/Reply and Time Exceeded messages.

**Procedure**
```bash
bash commands.sh        # runs a safe tour of the commands (tcpdump needs sudo)
```

**Program**
```bash
#!/bin/bash
H=${1:-google.com}
ifconfig || ip addr
netstat -tn | head -15
nslookup $H
ping -c 4 $H
traceroute -m 10 $H
```

**Sample Output:** interface details, active connections, resolved IP, ping round-trip times, and the router hops to the destination.

**Result:** The network commands were run successfully and ping/traceroute packets were captured and examined.

## Notes
`ifconfig` is Linux/macOS (`ip addr` on newer Linux); `ipconfig` is Windows. `traceroute` is Linux/macOS; `tracert` is Windows. Ping a reachable host (e.g. `ping -c 4 8.8.8.8`) to show a successful run rather than 100% loss.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
