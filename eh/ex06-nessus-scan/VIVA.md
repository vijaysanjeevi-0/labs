# ex06-nessus-scan viva — Vulnerability Scanning using Nessus

1. **What is CVSS?** Common Vulnerability Scoring System — a 0-10 standardised severity score for a vulnerability.
2. **How does a vulnerability scanner like Nessus find issues?** It matches target responses (banners, versions, configs) against a plugin database of known CVEs and misconfigurations.
3. **What is a false positive in scanning?** A finding the scanner reports as vulnerable that isn't actually exploitable in context — needs manual verification.
4. **Why is the vsftpd 2.3.4 finding rated CVSS 10.0?** It gives an unauthenticated attacker a full remote root shell — maximum impact, no privileges needed.
5. **Vulnerability scan vs penetration test?** A scan identifies potential weaknesses automatically; a pentest goes further and actually attempts to exploit them to confirm real-world impact.