# ex02-reconnaissance viva — Basics of Reconnaissance

1. **Passive vs active reconnaissance?** Passive never touches the target (WHOIS, public DNS, search engines); active sends packets to it directly (ping, traceroute, scans).
2. **What does `dig any` return?** Every DNS record type held for the domain — A, MX, NS, TXT etc — in one query.
3. **Why look up MX records specifically?** They reveal the organisation's mail infrastructure, a common attack surface (phishing, mail relay abuse).
4. **What can traceroute reveal about a target's network?** The router hops (and sometimes ISP/hosting provider) between you and the target, hinting at network topology.
5. **What is Shodan?** A search engine that indexes internet-facing devices and services by banner/port, useful for finding exposed infrastructure.