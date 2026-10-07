# Ex 8 — TCP / UDP performance using NS2

**Aim:** Simulate and compare the performance of TCP and UDP using NS2.

## TCP vs UDP
| TCP | UDP |
|-----|-----|
| Connection-oriented, reliable, ordered | Connectionless, unreliable, no ordering |
| Flow and congestion control | No congestion control |
| Acknowledgements and retransmission | No acknowledgements |
| Used by web, email, FTP | Used by DNS, VoIP, streaming |

## Algorithm (TCP, `tcp.tcl`)
1. Create a simulator object.
2. Open trace and NAM files.
3. Schedule a `flush-trace; exit` at the end instead of a separate `finish` procedure.
4. Create nodes n0-n3 and the links (n0-n2, n1-n2 at 5 Mb; n2-n3 at 1.5 Mb).
5. Create a TCP agent on n1 and a TCPSink on n3; connect them.
6. Attach an FTP application to the TCP agent.
7. Start FTP at 0.2 s and end the simulation at 3.0 s.
8. Run.

## Algorithm (UDP, `udp.tcl`)
Steps 1-4 as above (links only; no NAM orientation lines). Then create two UDP agents (n0 and n3), attach CBR traffic to each, create two Null agents on n1, connect each UDP agent to a Null agent, start the CBR sources at 1.0 s and 1.1 s, finish at 3.0 s, run.

## Run
```bash
ns tcp.tcl
nam tcpout.nam
awk -v node=3 -v dur=2.8 -f throughput.awk tcpout.tr   # throughput and drops at node 3

ns udp.tcl
nam udpout.nam
awk -v node=1 -v dur=2 -f throughput.awk udpout.tr     # node 1 receives the UDP flow
```
Measured with this script: ~1.46 Mbps TCP throughput, which fills the 1.5 Mb bottleneck link.

## What was fixed
- The manual detached the TCP agents at 1.35 s, so only 0.15 s of data flowed. FTP now runs until 3.0 s.
- Removed `xgraph tcpout.tr`, which cannot plot a raw trace file. Use `throughput.awk` for numbers.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
