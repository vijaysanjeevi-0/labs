$1 == "r" && $4 == node && ($5 == "tcp" || $5 == "cbr") { bytes += $6 }
$1 == "d" { drops++ }
END { printf "Throughput: %.1f kbps  Drops: %d\n", bytes * 8 / dur / 1000, drops }
