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
