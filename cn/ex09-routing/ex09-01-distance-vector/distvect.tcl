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
