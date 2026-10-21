# Ex 02 — Basics of Reconnaissance

**Aim:** To practise passive and active reconnaissance techniques to gather information about a target.

**Apparatus / Tools required:** Terminal, whois, nslookup, host, dig, traceroute, a browser (for Shodan/ipinfo.io).

**Algorithm**
1. Passive recon — query public records without touching the target: WHOIS, DNS lookups, Shodan.
2. Active recon — interact directly with the target: ping, traceroute, port/service probes.
3. Record every IP range, domain, mail server and OS fingerprint found, for use in later experiments.

**Procedure / Commands (in order)**
```bash
whois example.com                        # registrar, creation date, name servers
nslookup example.com                      # resolve the domain's IP
host -t mx example.com                    # find its mail servers
dig any example.com                       # dump all DNS record types
traceroute example.com                    # map the network path to it
# browser: https://www.ipinfo.io/<ip>      -> geolocate the resolved IP
# browser: https://www.shodan.io           -> search exposed services for that IP
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
$ whois google.com
Domain Name: GOOGLE.COM
Registrar: MarkMonitor Inc.
Creation Date: 1997-09-15
Registrar WHOIS Server: whois.markmonitor.com

$ nslookup google.com
Server:   8.8.8.8
Address:  8.8.8.8#53
Non-authoritative answer:
Name: google.com  Address: 142.250.195.46
```

**Result:** Passive and active reconnaissance techniques were performed successfully, gathering domain, IP and DNS information about the target.
