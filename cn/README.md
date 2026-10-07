# cn — Computer Networks Lab

Corrected, tested code for the 10 lab exercises. Each folder has its own `README.md` with the **aim, algorithm, how to run, and expected output**.

| # | Folder | Topic | Language |
|---|--------|-------|----------|
| 1 | [`ex01-network-commands`](ex01-network-commands) | tcpdump, netstat, ifconfig/ipconfig, nslookup, traceroute, ping | shell |
| 2 | [`ex02-http-client`](ex02-http-client) | HTTP client downloading a web page over TCP sockets | Java |
| 3 | [`ex03-tcp-applications`](ex03-tcp-applications) | Echo client/server, UDP chat, file transfer | Java |
| 4 | [`ex04-dns-udp`](ex04-dns-udp) | DNS simulation using UDP sockets | Java |
| 5 | [`ex05-wireshark`](ex05-wireshark) | Capturing and examining packets with Wireshark | procedure |
| 6 | [`ex06-arp-rarp`](ex06-arp-rarp) | ARP (TCP) and RARP (UDP) simulation | Java |
| 7 | [`ex07-congestion-control`](ex07-congestion-control) | Congestion control (slow start, AIMD) in NS2 | Tcl |
| 8 | [`ex08-tcp-udp-performance`](ex08-tcp-udp-performance) | TCP vs UDP performance in NS2 | Tcl + awk |
| 9 | [`ex09-routing`](ex09-routing) | Link State and Distance Vector routing in NS2 | Tcl |
| 10 | [`ex10-crc`](ex10-crc) | CRC error detection | Java |

## Viva
[`VIVA.md`](VIVA.md) has general questions (layers, TCP/UDP, addressing, devices). Each exercise folder also has its own `VIVA.md` with questions specific to that experiment.

## Structure
```
cn/
├── README.md
├── VIVA.md                  (general viva questions)
├── .gitignore
├── ex01-network-commands/   README.md, VIVA.md, commands.sh
├── ex02-http-client/        README.md, VIVA.md, src/HttpClient.java
├── ex03-tcp-applications/   README.md, VIVA.md, echo/, udp-chat/, file-transfer/
├── ex04-dns-udp/            README.md, VIVA.md, src/{UdpDnsServer,UdpDnsClient}.java
├── ex05-wireshark/          README.md, VIVA.md
├── ex06-arp-rarp/           README.md, VIVA.md, arp/, rarp/
├── ex07-congestion-control/ README.md, VIVA.md, congestion.tcl
├── ex08-tcp-udp-performance/README.md, VIVA.md, tcp.tcl, udp.tcl, throughput.awk
├── ex09-routing/            README.md, VIVA.md, linkstate.tcl, distvect.tcl
└── ex10-crc/                README.md, VIVA.md, Crc.java
```

## Requirements
- JDK 11+ (`javac`, `java`) for exercises 2, 3, 4, 6, 10
- NS2 (`sudo apt install ns2 nam`) for exercises 7, 8, 9
- Wireshark, tcpdump for exercises 1 and 5

All Java exercises were compiled and run, and all NS2 scripts executed with `ns`, before being added here. For Java, run server and client in **separate terminals**, server first.

## What was fixed from the lab manual
Missing semicolons/brackets, misplaced `System.out.println(e)`, `geyLocalHost` typo, stray `*/`, unreachable code after `break`, `proc finish {}` brace placement in Tcl, UDP buffer truncation ("Hello Clie"), echo server looping forever after the client disconnects, ARP server hanging on unknown IPs, DNS server creating its socket inside the loop, and TCP script stopping after 0.15 s. Details are in each exercise's README.

The code is kept deliberately short: standard formatting, one statement per line, no optional arguments or banner prints beyond what the lab output needs. Hosts are hard-coded to `localhost`.
