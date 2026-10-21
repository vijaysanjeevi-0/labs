# General viva questions — Ethical Hacking

Exercise-specific questions are in the `VIVA.md` inside each exercise folder.

1. **What is ethical hacking?** Authorised testing of a system's security, using the same techniques as an attacker, to find and fix weaknesses before they're exploited maliciously.
2. **What is the standard phase order of a penetration test?** Reconnaissance → scanning/enumeration → gaining access (exploitation) → maintaining access → covering tracks → reporting.
3. **Why always test only your own lab VMs?** Testing systems you don't own/have written permission for is illegal, regardless of intent — the "Computer Misuse"-style laws apply.
4. **White hat vs black hat vs grey hat?** White hat: authorised, ethical. Black hat: unauthorised, malicious. Grey hat: unauthorised but without malicious intent (still illegal without permission).
5. **What is a CVE?** Common Vulnerabilities and Exposures — a public, uniquely-numbered catalogue entry for a known security flaw.
6. **OSINT?** Open-Source Intelligence — gathering information from publicly available sources without directly touching the target.
7. **What is the difference between a vulnerability scanner and an exploitation framework?** A scanner (Nessus) finds and reports weaknesses; a framework (Metasploit) actually weaponises and fires exploits against them.
8. **Why use a host-only network for Kali/Metasploitable?** It keeps attack traffic contained to the lab, isolated from the real network and the internet.
