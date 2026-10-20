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
