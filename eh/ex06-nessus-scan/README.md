# Ex 06 — Vulnerability Scanning using Nessus

**Aim:** To scan a target system for security vulnerabilities using Nessus.

**Apparatus / Tools required:** Nessus Essentials, Kali Linux, Metasploitable2 (target).

**Algorithm**
1. Install and license Nessus, start its service and reach its web UI.
2. Define a scan policy (Basic Network Scan) and target IP.
3. Launch the scan; Nessus tests the target against its plugin database (CVEs, misconfigs, default creds, missing patches).
4. Review and export findings, sorted by CVSS severity.

**Procedure / Commands (in order)**
```bash
# 1. Register for a free Nessus Essentials licence (tenable.com)
sudo dpkg -i Nessus-*.deb
sudo systemctl start nessusd
# browser: https://localhost:8834  -> complete setup with the activation code

# 2. In the UI: New Scan -> Basic Network Scan
#    Target = 192.168.56.102   (Metasploitable2)
#    Save -> Launch, wait ~10-20 min

# 3. Review results sorted by severity; export: Report -> PDF
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
[Nessus Scan Summary - Metasploitable2]
Scan completed: 2024-04-10 14:32:05
Severity   Count
---------  -----
Critical   8
High       23
Medium     17
Low        5
Info       42

Top Critical Finding:
CVE-2011-2523 - vsftpd 2.3.4 Backdoor Command Execution
CVSS Score: 10.0 | Port 21/tcp
```

**Result:** Nessus completed the vulnerability scan and identified critical vulnerabilities, including the vsftpd backdoor, on the target.
