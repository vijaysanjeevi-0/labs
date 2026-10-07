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
