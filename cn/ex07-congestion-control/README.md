# Ex 7 — Congestion control simulation (NS2)

**Aim:** Study NS2 and simulate TCP (Reno) congestion control.

## Topology
Dumbbell: n0 and n1 feed into n2 at 10 Mb each; n2–n3 is the 1 Mb bottleneck; n3 fans out to sinks n4 and n5 at 10 Mb each. Two TCP Reno flows share the bottleneck: n0 → n4 and n1 → n5.

```
n0 --10Mb--\                                   /--10Mb-- n4
             n2 ====1Mb,20ms(bottleneck)==== n3
n1 --10Mb--/                                   \--10Mb-- n5

Flow A: n0 -> n4   |   Flow B: n1 -> n5   (both cross the n2-n3 bottleneck)
```

## Algorithm
1. Create a simulator object; trace to `congestion.nam`.
2. Create nodes n0–n5 and the links above; set a queue limit of 10 packets on the bottleneck.
3. Define a `plot` procedure that logs each TCP connection's congestion window (`cwnd_`) every 0.1 s.
4. Start a TCP Reno connection n0→n4 at 0.1 s and n1→n5 at 1.0 s (staggered so their slow-start phases don't align), each running FTP.
5. Stop at 20 s.

```bash
ns congestion.tcl
nam congestion.nam
```

**Expected output:** `cwnd0.tr` and `cwnd1.tr` each show the classic TCP Reno sawtooth — slow start (exponential growth) until the bottleneck queue fills and a packet is dropped, then additive-increase/multiplicative-decrease (cwnd halves and climbs linearly) from there on, with the two flows alternating who backs off as they compete for the shared 1 Mb link.
