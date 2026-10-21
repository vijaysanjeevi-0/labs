# ex05-robtex viva — Information Gathering using Robtex

1. **What does 'shared-IP neighbours' mean, and why does it matter?** Other domains hosted on the same server/IP — compromising a weaker neighbour can sometimes lead to the real target on shared hosting.
2. **What is a PTR record?** A reverse-DNS record that maps an IP address back to a hostname.
3. **What is BGP, briefly?** The protocol that exchanges routing information between autonomous systems on the internet, determining which network owns/announces an IP block.
4. **Why cross-check Robtex results with a direct `nslookup`?** Robtex's cached/historical DNS data can be stale; a live query confirms the current records.
5. **How is this different from WHOIS (ex02)?** WHOIS gives registration/ownership info for the domain name itself; Robtex focuses on DNS/hosting infrastructure and co-located domains.