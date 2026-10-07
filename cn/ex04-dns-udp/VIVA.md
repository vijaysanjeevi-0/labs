# Ex 4 viva — DNS using UDP

1. **What is DNS?** A distributed hierarchical database that translates domain names to IP addresses.
2. **Why UDP (port 53)?** Queries and answers are small and need one round trip; no connection setup. TCP is used for zone transfers and large responses.
3. **Common record types?** A (IPv4), AAAA (IPv6), MX (mail), NS (name server), CNAME (alias), PTR (reverse lookup), SOA.
4. **Recursive vs iterative query?** Recursive: the server finds the full answer for the client. Iterative: the server returns a referral to the next server.
5. **Types of name servers?** Root, primary (authoritative, owns the zone file), secondary (copies the zone from the primary).
6. **Domain name space sections?** Generic (.com), country (.in) and inverse (IP → name).
7. **What is DNS caching and TTL?** Resolvers store answers for the record's TTL to reduce load and delay.
8. **Root servers?** Top of the hierarchy; they refer queries to the top-level-domain servers.
9. **How does this program differ from real DNS?** It uses a fixed in-memory table and port 1362 instead of 53, with no recursion, caching or record types.
10. **What if the host is not in the table?** The server replies `Host Not Found`.
11. **What does `nslookup` use?** The same protocol to query a DNS server.
