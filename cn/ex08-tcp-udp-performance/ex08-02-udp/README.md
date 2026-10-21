# Ex 8.2 — UDP performance (NS2)

**Aim:** Simulate UDP traffic in NS2 and measure its throughput/loss.

**Apparatus / Tools required:** NS2 (`ns`), NAM, `awk`.

**Topology**
Same dumbbell as the TCP test: n0 and n1 feed into n2 at 5 Mb each; n2-n3 is the 1.5 Mb bottleneck. Two CBR/UDP flows both sink at n1: n0 -> n1 and n3 -> n1.

**Algorithm**
1. Create a simulator object; open trace and NAM files.
2. Create nodes n0-n3 and the same links as the TCP case.
3. Create two UDP agents (on n0 and n3) and two Null agents (on n1) as sinks; connect each UDP agent to a Null agent.
4. Attach CBR (constant bit rate) traffic to each UDP agent.
5. Start the CBR sources at 1.0 s and 1.1 s, finish at 3.0 s, run.

**Procedure**
```bash
ns udp.tcl
nam udpout.nam
awk -v node=1 -v dur=2 -f throughput.awk udpout.tr     # node 1 receives both UDP flows
```

**Program**

`udp.tcl`
```tcl
set ns [new Simulator]
$ns namtrace-all [open udpout.nam w]
$ns trace-all [open udpout.tr w]
foreach i {0 1 2 3} {set n($i) [$ns node]}
$ns duplex-link $n(0) $n(2) 5Mb 2ms DropTail
$ns duplex-link $n(1) $n(2) 5Mb 2ms DropTail
$ns duplex-link $n(2) $n(3) 1.5Mb 10ms DropTail
foreach {src t} {0 1.0  3 1.1} {
    set cbr [new Application/Traffic/CBR]
    $cbr attach-agent [$ns create-connection UDP $n($src) Null $n(1) 0]
    $ns at $t "$cbr start"
}
$ns at 3.0 "$ns flush-trace; exit"
$ns run
```
`throughput.awk`
```awk
$1 == "r" && $4 == node && ($5 == "tcp" || $5 == "cbr") { bytes += $6 }
$1 == "d" { drops++ }
END { printf "Throughput: %.1f kbps  Drops: %d\n", bytes * 8 / dur / 1000, drops }
```

**Sample Output:** throughput close to the CBR send rate, with any loss shown by `throughput.awk` once the link is saturated.

**Result:** UDP performance was simulated in NS2 and its throughput/loss measured successfully.
