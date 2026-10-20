# ex03 viva — Cross-Site Scripting

1. **What is XSS?** Injecting malicious scripts into a trusted website so they run in other users' browsers.
2. **Stored vs reflected vs DOM-based XSS?** Stored: payload saved on the server (e.g. a comment) and served to everyone; reflected: payload bounced back immediately in the response (e.g. a search result); DOM-based: the script manipulates the page's DOM purely client-side.
3. **How does `htmlspecialchars()` prevent XSS?** It converts characters like `<`, `>` and `"` into HTML entities, so injected markup is displayed as text instead of being executed.
4. **What is a Content-Security-Policy header for?** It restricts which sources scripts/styles can load from, blocking inline/injected scripts even if one slips through.
5. **Why is stored XSS more dangerous than reflected?** It affects every visitor who views the stored content, not just a user tricked into clicking one crafted link.
