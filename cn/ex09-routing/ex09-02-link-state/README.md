# Ex 9.2 — Link State routing (NS2)

**Aim:** Simulate Link State routing (Dijkstra, OSPF/IS-IS-style) using NS2.

**Apparatus / Tools required:** NS2 (`ns`), NAM.

**Topology**
7-node ring, each link 1 Mb / 10 ms. Traffic flows n0 -> n3; link n1-n2 is cut mid-simulation.
```
          n0 ---- n1
         /            \
       n6              n2   <-- link n1-n2 cut 1.0-2.0s
        |                |
       n5              n3  <-- CBR traffic n0 -> n3
         \            /
              n4
```

**Algorithm**
1. Create a simulator object, set `rtproto LS`.
2. Open the NAM trace file.
3. Create 7 nodes n0-n6 and link each to the next, wrapping around (ring).
4. Attach a UDP agent + CBR traffic (packetSize 500, interval 0.005) from n0 to sink n3.
5. Schedule: traffic starts 0.5 s; link n1-n2 goes down at 1.0 s, back up at 2.0 s; finish at 5.0 s.
6. Run, then watch in NAM how traffic reroutes the long way round the ring while the link is down.

**Procedure**
```bash
ns linkstate.tcl
nam linkstate.nam
```

**Program**
```tcl
set ns [new Simulator]
$ns rtproto LS
$ns namtrace-all [open linkstate.nam w]
for {set i 0} {$i < 7} {incr i} {set n($i) [$ns node]}
for {set i 0} {$i < 7} {incr i} {
    $ns duplex-link $n($i) $n([expr ($i+1)%7]) 1Mb 10ms DropTail
}
set cbr [new Application/Traffic/CBR]
$cbr set packetSize_ 500
$cbr set interval_ 0.005
$cbr attach-agent [$ns create-connection UDP $n(0) Null $n(3) 0]
$ns at 0.5 "$cbr start"
$ns rtmodel-at 1.0 down $n(1) $n(2)
$ns rtmodel-at 2.0 up $n(1) $n(2)
$ns at 5.0 "$ns flush-trace; exit"
$ns run
```

**Sample Output:** `linkstate.nam` shows traffic flowing n0->n3 the short way (n0->n1->n2->n3), rerouting the long way (n0->n6->n5->n4->n3) during the 1-2 s outage, then returning to the direct path.

**Result:** Link State routing was simulated in NS2 and its rerouting behaviour observed successfully.

## Notes
Same `proc finish {}` syntax issue as the distance-vector script, fixed the same way.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General and routing questions are in the [base VIVA.md](../VIVA.md).
