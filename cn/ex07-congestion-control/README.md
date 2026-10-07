# Ex 7 — Study of NS2 and simulation of congestion control algorithms

**Aim:** Study the Network Simulator (NS2) and simulate TCP congestion control (slow start, AIMD, fast retransmit / fast recovery).

## NS2 in brief
- Discrete-event simulator. Scripts are written in Tcl; results go to a **trace file** (`.tr`, every packet event) and a **NAM file** (`.nam`, animation).
- Trace line format: `event time from to type size flags flow src dst seq id` where event is `+` enqueue, `-` dequeue, `r` receive, `d` drop.
- Metrics studied: packet loss, throughput, delay, queue length.

## Congestion control algorithms
| Algorithm | Idea |
|-----------|------|
| Slow start | cwnd starts at 1 and doubles each RTT until `ssthresh` |
| AIMD | after that, add 1 per RTT (additive increase); halve on loss (multiplicative decrease) |
| Fast retransmit | 3 duplicate ACKs trigger retransmit without waiting for the timeout |
| Fast recovery | after fast retransmit, continue from `ssthresh` instead of restarting slow start |

## Algorithm (script)
1. Create the simulator and open trace, NAM and cwnd files.
2. Create 6 nodes: two senders (n0, n1) → router n2 → bottleneck link (1 Mb, queue limit 10) → router n3 → receivers (n4, n5).
3. Attach TCP Reno agents to the senders and TCP sinks to the receivers; connect them.
4. Attach FTP applications. Start flow 1 at 0.1 s and flow 2 at 1.0 s.
5. Every 0.1 s record each flow's `cwnd_` in `cwnd0.tr` / `cwnd1.tr`.
6. Stop at 20 s, flush and close files.

## Run
```bash
ns congestion.tcl
xgraph cwnd0.tr cwnd1.tr      # plot cwnd vs time (sawtooth = AIMD)
nam congestion.nam            # animation
```
The curve rises exponentially at first (slow start), then drops sharply when the bottleneck queue overflows, and the two flows converge toward an equal share.

## What changed from the manual
The manual's "program" was a fragment of a DCCP/TFRC C++ agent (history-list helper functions) that is not a runnable simulation and does not demonstrate congestion control. It was replaced with a complete, tested Tcl simulation.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
