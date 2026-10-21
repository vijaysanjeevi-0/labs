# Ex 9.1 — Distance Vector routing (NS2)

**Aim:** Simulate Distance Vector routing (Bellman-Ford, RIP/IGRP-style) using NS2.

**Apparatus / Tools required:** NS2 (`ns`), NAM.

**Topology**
8-node ring (octagon), each link 1 Mb / 10 ms. Traffic flows n0 -> n3; link n2-n3 is cut mid-simulation, forcing traffic the long way round.
```
                n0 ---- n1
               /            \
             n7              n2
              |                |
             n6              n3  <-- CBR traffic n0 -> n3
               \            /       (link n2-n3 cut 1.0-2.0s)
                n5 ---- n4
```

**Algorithm**
1. Create a simulator object, set `rtproto DV`.
2. Open NAM/trace files.
3. Create 8 nodes n0-n7 and link each to the next, wrapping around (ring).
4. Attach a UDP agent + CBR traffic (packetSize 500, interval 0.005) from n0 to sink n3.
5. Schedule: traffic starts 0.5 s; link n2-n3 goes down at 1.0 s, back up at 2.0 s; finish at 5.0 s.
6. Run, then watch in NAM how traffic reroutes the long way round the ring while the link is down.

**Procedure**
```bash
ns distvect.tcl
nam -a out.nam
```

**Program**
```tcl
set ns [new Simulator]
$ns rtproto DV
$ns namtrace-all [open out.nam w]
$ns trace-all [open trace.tr w]
set o {left-up up right-up right right-down down left-down left}
for {set i 0} {$i < 8} {incr i} {set n($i) [$ns node]}
for {set i 0} {$i < 8} {incr i} {
    set j [expr ($i+1)%8]
    $ns duplex-link $n($i) $n($j) 1Mb 10ms DropTail
    $ns duplex-link-op $n($i) $n($j) orient [lindex $o $i]
}
set cbr [new Application/Traffic/CBR]
$cbr set packetSize_ 500
$cbr set interval_ 0.005
$cbr attach-agent [$ns create-connection UDP $n(0) Null $n(3) 0]
$ns at 0.5 "$cbr start"
$ns rtmodel-at 1.0 down $n(2) $n(3)
$ns rtmodel-at 2.0 up $n(2) $n(3)
$ns at 5.0 "$ns flush-trace; exit"
$ns run
```

**Sample Output:** `out.nam` shows traffic flowing n0->n3 directly (via n1->n2->n3), rerouting the long way round (n0->n7->n6->n5->n4->n3) during the 1-2 s outage, then returning to the direct path once the link is restored.

**Result:** Distance Vector routing was simulated in NS2 and its rerouting behaviour observed successfully.

## Notes
`proc finish {}` followed by `{` on a new line was a Tcl syntax error — replaced with one scheduled `flush-trace; exit` line.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General and routing questions are in the [base VIVA.md](../VIVA.md).
