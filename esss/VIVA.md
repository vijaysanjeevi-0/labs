# General viva questions — Engineering Secure Software Systems

Exercise-specific questions are in the `VIVA.md` inside each exercise folder.

1. **CIA triad?** Confidentiality, Integrity, Availability — the three core goals of information security.
2. **What is the OWASP Top 10?** A standard awareness list of the most critical web application security risks (injection, broken auth, XSS, etc.).
3. **Input validation vs output encoding — why both?** Validation rejects/limits malformed input at the boundary; encoding neutralises any dangerous characters when data is later rendered or used in a query, protecting even inputs that passed validation.
4. **What is the principle of least privilege?** Every user/process should have only the access it needs to do its job, nothing more.
5. **Vulnerability vs exploit vs threat?** A vulnerability is a weakness; an exploit is a technique that takes advantage of it; a threat is a potential event that could cause harm.
6. **What is penetration testing?** Authorised simulated attacks on a system to find and report exploitable weaknesses before real attackers do.
7. **Why defense in depth?** Multiple independent layers of security mean one failed control doesn't fully compromise the system.
