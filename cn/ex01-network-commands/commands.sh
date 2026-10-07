#!/bin/bash
H=${1:-google.com}
ifconfig || ip addr
netstat -tn | head -15
nslookup $H
ping -c 4 $H
traceroute -m 10 $H
