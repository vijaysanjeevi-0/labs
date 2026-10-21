# Ex 03 — Metadata Extraction using FOCA / SearchDiggity

**Aim:** To extract metadata from publicly available documents and expand the target list using FOCA.

**Apparatus / Tools required:** FOCA (Windows), SearchDiggity, a browser, Google Dorks.

**Algorithm**
1. Harvest public documents (PDF/DOCX/XLSX/PPTX) belonging to the target domain via search-engine queries.
2. Download them and parse embedded metadata (author, software version, file paths).
3. Correlate usernames/hostnames found across documents to map internal systems and staff.

**Procedure / Commands (in order)**
```
# FOCA GUI workflow
File -> New Project -> enter target domain
Search All                                  # FOCA queries Google/Bing for .pdf/.docx/.xlsx/.pptx
select all results -> Download
Extract All Metadata
Network tab                                 # discovered internal hostnames / IPs
Project -> Generate Report

# Manual Google Dork, same idea without the GUI
site:example.com filetype:pdf
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
[FOCA Output]
Documents found: 47
Documents downloaded: 38
Metadata extracted from: 35 files
Users found:
 - john.smith (MS Word 2016)
 - adminIT (Adobe Acrobat 11)
Internal paths found:
 - \\FILESERVER01\shared\reports\
 - C:\Users\john.smith\Documents\
```

**Result:** Metadata was successfully extracted from public documents, revealing usernames, software versions, and internal network paths.
