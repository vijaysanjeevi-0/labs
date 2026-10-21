# Ex 7 — Congestion control simulation (NS2)

**Aim:** Study NS2 and simulate TCP (Reno) congestion control.

**Apparatus / Tools required:** NS2 (`ns`), NAM.

**Topology**
Dumbbell: n0 and n1 feed into n2 at 10 Mb each; n2-n3 is the 1 Mb bottleneck; n3 fans out to sinks n4 and n5 at 10 Mb each. Two TCP Reno flows share the bottleneck: n0 -> n4 and n1 -> n5.
```
n0 --10Mb--\                                   /--10Mb-- n4
             n2 ====1Mb,20ms(bottleneck)==== n3
n1 --10Mb--/                                   \--10Mb-- n5
```

**Algorithm**
1. Create a simulator object; trace to `congestion.nam`.
2. Create nodes n0-n5 and the links above; set a queue limit of 10 packets on the bottleneck.
3. Define a `plot` procedure that logs each TCP connection's congestion window (`cwnd_`) every 0.1 s.
4. Start a TCP Reno connection n0->n4 at 0.1 s and n1->n5 at 1.0 s (staggered), each running FTP.
5. Stop at 20 s.

**Procedure**
```bash
ns congestion.tcl
nam congestion.nam
```

**Program**
```tcl
set ns [new Simulator]
$ns namtrace-all [open congestion.nam w]
foreach i {0 1 2 3 4 5} {set n($i) [$ns node]}
foreach {a b bw d} {0 2 10Mb 2ms  1 2 10Mb 2ms  2 3 1Mb 20ms  3 4 10Mb 2ms  3 5 10Mb 2ms} {
    $ns duplex-link $n($a) $n($b) $bw $d DropTail
}
$ns queue-limit $n(2) $n(3) 10
proc plot {tcp f} {
    global ns
    puts $f "[$ns now] [$tcp set cwnd_]"
    $ns at [expr [$ns now]+0.1] "plot $tcp $f"
}
foreach i {0 1} {
    set tcp [$ns create-connection TCP/Reno $n($i) TCPSink $n([expr $i+4]) $i]
    $ns at [expr 0.1+0.9*$i] "[$tcp attach-app FTP] start; plot $tcp [open cwnd$i.tr w]"
}
$ns at 20 "$ns flush-trace; exit"
$ns run
```

**Sample Output:** `cwnd0.tr` and `cwnd1.tr` each show the classic TCP Reno sawtooth: slow start (exponential growth) until the bottleneck queue fills and a packet is dropped, then additive-increase/multiplicative-decrease (cwnd halves, then climbs linearly) from there, with the two flows alternating who backs off as they compete for the shared 1 Mb link.

**Result:** TCP Reno congestion control was simulated in NS2 and its congestion-window behaviour observed successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
