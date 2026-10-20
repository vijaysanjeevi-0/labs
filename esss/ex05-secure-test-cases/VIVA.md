# ex05 viva — Secure test cases

1. **What is a secure test case?** A test designed to verify a security property (e.g. "XSS payload is not reflected") rather than just functional correctness.
2. **Why use Selenium for this?** It drives a real browser, so it can check what the page actually renders/executes, not just the raw HTTP response.
3. **What does the assertion `"alert" not in driver.page_source` check?** That the injected script did not end up rendered verbatim (i.e. it was escaped, not executed).
4. **Manual vs automated security testing?** Manual uses tools like Burp/Postman interactively; automated runs repeatable scripted checks, useful in CI pipelines.
5. **Why re-test after a fix?** To confirm the vulnerability is actually closed and that the fix didn't break the expected functionality.
