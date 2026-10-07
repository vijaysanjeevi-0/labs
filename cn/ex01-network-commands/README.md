# Ex 1 — Network commands

**Aim:** Learn tcpdump, netstat, ifconfig/ipconfig, nslookup, traceroute and ping, and capture ping/traceroute PDUs with a protocol analyzer.

## Algorithm / procedure
1. Check your interface configuration (`ifconfig` / `ipconfig`).
2. List active connections and listening ports (`netstat`).
3. Resolve a domain name with `nslookup`.
4. Test reachability with `ping`.
5. Trace the route with `traceroute` (Linux/macOS) or `tracert` (Windows).
6. In a second terminal run `tcpdump`, or start Wireshark, while repeating steps 4-5 to capture the ICMP packets.
7. Examine the captured ICMP Echo Request/Reply and Time Exceeded messages.

## Run
```bash
bash commands.sh        # runs a safe tour of the commands (tcpdump needs sudo)
```

## Notes
- `ifconfig` is Linux/macOS (`ip addr` on newer Linux); `ipconfig` is Windows.
- `traceroute` is Linux/macOS; `tracert` is Windows. The manual's screenshot shows `'traceroute' is not recognized` before it switches to `tracert`, which is expected on Windows.
- In the manual's ping screenshot, 4 of 4 packets are lost (100% loss) because `172.16.6.2` was unreachable. Ping a reachable host (e.g. `ping -c 4 8.8.8.8`) to show a successful run.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
