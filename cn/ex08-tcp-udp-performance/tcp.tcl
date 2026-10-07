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
