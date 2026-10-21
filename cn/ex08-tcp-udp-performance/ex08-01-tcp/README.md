# Ex 8.1 — TCP performance (NS2)

**Aim:** Simulate TCP traffic in NS2 and measure its throughput.

**Apparatus / Tools required:** NS2 (`ns`), NAM, `awk`.

**Topology**
Dumbbell: n0 and n1 feed into n2 at 5 Mb each; n2-n3 is the 1.5 Mb bottleneck link. The TCP flow runs n1 -> n3.
```
n0 --5Mb,2ms--\
                n2 ====1.5Mb,10ms(bottleneck)==== n3
n1 --5Mb,2ms--/        ^
                  TCP flow: n1 -> n3
```

**Algorithm**
1. Create a simulator object; open trace and NAM files.
2. Create nodes n0-n3 and links (n0-n2, n1-n2 at 5 Mb; n2-n3 at 1.5 Mb bottleneck).
3. Create a TCP agent on n1 and a TCPSink on n3; connect them.
4. Attach an FTP application to the TCP agent.
5. Start FTP at 0.2 s, end the simulation at 3.0 s, run.

**Procedure**
```bash
ns tcp.tcl
nam tcpout.nam
awk -v node=3 -v dur=2.8 -f throughput.awk tcpout.tr   # throughput and drops at node 3
```

**Program**

`tcp.tcl`
```tcl
set ns [new Simulator]
$ns namtrace-all [open tcpout.nam w]
$ns trace-all [open tcpout.tr w]
foreach i {0 1 2 3} {set n($i) [$ns node]}
$ns duplex-link $n(0) $n(2) 5Mb 2ms DropTail
$ns duplex-link $n(1) $n(2) 5Mb 2ms DropTail
$ns duplex-link $n(2) $n(3) 1.5Mb 10ms DropTail
set tcp [$ns create-connection TCP $n(1) TCPSink $n(3) 0]
$ns at 0.2 "[$tcp attach-app FTP] start"
$ns at 3.0 "$ns flush-trace; exit"
$ns run
```
`throughput.awk`
```awk
$1 == "r" && $4 == node && ($5 == "tcp" || $5 == "cbr") { bytes += $6 }
$1 == "d" { drops++ }
END { printf "Throughput: %.1f kbps  Drops: %d\n", bytes * 8 / dur / 1000, drops }
```

**Sample Output:** ~1.46 Mbps throughput, close to filling the 1.5 Mb bottleneck link.

**Result:** TCP performance was simulated in NS2 and its throughput measured successfully.

## Notes
The manual detached the TCP agents at 1.35 s, so only 0.15 s of data flowed — fixed to run until 3.0 s.
