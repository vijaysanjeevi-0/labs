# Ex 07 — Network Traffic Capture using Wireshark

**Aim:** To capture and analyse live network traffic using Wireshark.

**Apparatus / Tools required:** Wireshark, Kali Linux, tshark (CLI version).

**Algorithm**
1. Start a packet capture on the target interface.
2. Generate traffic to observe (ICMP via ping, HTTP via browser, FTP login).
3. Apply display filters to isolate the protocol of interest.
4. Reconstruct a full session with "Follow TCP Stream" to read plaintext credentials/data.
5. Save the capture for later analysis.

**Procedure / Commands (in order)**
```bash
sudo wireshark                      # launch, select interface eth0, click the shark-fin icon to start

# from another terminal, generate traffic to see:
ping 192.168.56.102                 # ICMP
# browser -> any HTTP site           (then apply display filter: http)
ftp 192.168.56.102                  # log in with msfadmin/msfadmin (then apply filter: ftp)

# in Wireshark: right-click a packet -> Follow -> TCP Stream   (reconstructs the session)
# File -> Save As -> capture.pcap

# command-line capture instead of the GUI
tshark -i eth0 -w output.pcap -c 100
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
No.  Time      Source          Destination     Protocol  Info
---  --------  --------------  --------------  --------  ----
1    0.000000  192.168.56.101  192.168.56.102  ICMP      Echo (ping) request
2    0.001234  192.168.56.102  192.168.56.101  ICMP      Echo (ping) reply
3    0.500100  192.168.56.101  192.168.56.102  FTP       Request: USER msfadmin
4    0.501200  192.168.56.102  192.168.56.101  FTP       Response: 331 Password required
5    0.510000  192.168.56.101  192.168.56.102  FTP       Request: PASS msfadmin
```

**Result:** Wireshark successfully captured live network traffic, including ICMP, HTTP, and FTP credentials transmitted in plaintext.
