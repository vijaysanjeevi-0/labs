# Ex 05 — Information Gathering using Robtex

**Aim:** To gather network intelligence about a target using Robtex.

**Apparatus / Tools required:** Robtex (robtex.com), a web browser, terminal (for DNS commands).

**Algorithm**
1. Query Robtex for a domain to retrieve its DNS records (A, MX, NS, PTR).
2. Pivot from an IP to every other domain hosted on it (shared-hosting neighbours).
3. Check BGP/ASN data to identify the owning network.
4. Cross-check findings with a direct DNS query.

**Procedure / Commands (in order)**
```bash
# browser: https://www.robtex.com -> search "example.com"
#   -> review DNS section (A / MX / NS records)
#   -> click the IP to list every domain hosted on the same server
#   -> check the BGP tab for the ASN

# scripted lookup via the API
curl 'https://freeapi.robtex.com/pdns/forward/example.com'

# cross-reference directly
nslookup -type=any example.com 8.8.8.8
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
$ curl 'https://freeapi.robtex.com/pdns/forward/example.com'
[
 {"rrname":"example.com","rrtype":"A","rdata":"93.184.216.34",
  "time_first":1609459200,"time_last":1716000000},
 {"rrname":"example.com","rrtype":"MX","rdata":"mail.example.com",
  "time_first":1609459200,"time_last":1716000000}
]
Shared-IP neighbours: 12 additional domains found on 93.184.216.34
```

**Result:** Robtex successfully revealed DNS records, BGP information, and co-hosted domains for the target.
