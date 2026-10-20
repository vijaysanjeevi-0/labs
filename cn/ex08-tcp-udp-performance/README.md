# Ex 8 — TCP / UDP performance using NS2

**Aim:** Simulate and compare the performance of TCP and UDP using NS2.

| Folder | Program |
|---|---|
| `ex08-01-tcp/` | TCP simulation and throughput measurement |
| `ex08-02-udp/` | UDP simulation and throughput measurement |

Each has its own `README.md` and `VIVA.md`, and its own copy of `throughput.awk` (the trace-analysis helper, identical in both).

## TCP vs UDP
| TCP | UDP |
|-----|-----|
| Connection-oriented, reliable, ordered | Connectionless, unreliable, no ordering |
| Flow and congestion control | No congestion control |
| Acknowledgements and retransmission | No acknowledgements |
| Used by web, email, FTP | Used by DNS, VoIP, streaming |
