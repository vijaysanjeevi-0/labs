# Ex 04 — Information Gathering using Maltego

**Aim:** To aggregate information from public databases using Paterva's Maltego.

**Apparatus / Tools required:** Maltego CE (pre-installed on Kali), internet connection, a Maltego Community account.

**Algorithm**
1. Seed a graph with one entity (a domain).
2. Run transforms — queries against public data sources (DNS, WHOIS, social media, Shodan) — to expand related entities.
3. Chain further transforms on newly discovered entities (IPs, emails, people) to build a link-analysis graph.
4. Export the resulting graph/report.

**Procedure / Commands (in order)**
```
Applications -> Information Gathering -> Maltego
log in with a Maltego Community account
Run a Machine -> "Company Stalker" (or start a blank graph)
drag a Domain entity onto the canvas, set it to example.com
right-click -> Run Transform -> "To DNS Name [Using NS]"
right-click -> Run Transform -> "To IP Address"
right-click -> Run Transform -> "To Email Address [from domain WHOIS]"
right-click an email -> Run Transform -> "To Person [from email]"
Graph -> Export -> PNG or CSV
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
[Maltego Graph Summary]
Root entity: example.com
Discovered:
 DNS Names  : mail.example.com, ftp.example.com, vpn.example.com
 IP Addresses: 203.0.113.5, 203.0.113.6
 Email Addrs : admin@example.com, webmaster@example.com
 Persons    : John Smith (LinkedIn), Jane Doe (Twitter)
 ASN        : AS12345 - ExampleISP
```

**Result:** Maltego successfully aggregated information from public databases, visualising relationships between the target's online assets.
