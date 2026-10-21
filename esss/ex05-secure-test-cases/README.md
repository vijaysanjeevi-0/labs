# Ex 5 — Secure test cases (Selenium)

**Aim:** Write an automated secure test case that checks an XSS payload is *not* reflected.

**Apparatus / Tools required:** Python, Selenium, a Chrome/Chromedriver install, the target login page.

**Algorithm**
1. Open the login page in a real browser via Selenium.
2. Submit an XSS payload as the username.
3. Assert the payload does not appear unescaped (executable) in the resulting page source.

**Procedure**
```bash
pip install selenium
python test_login_xss.py
```

**Program**
```python
from selenium import webdriver

driver = webdriver.Chrome()
driver.get("http://localhost/login.php")

username = driver.find_element("name", "username")
username.send_keys("<script>alert('XSS')</script>")
driver.find_element("name", "submit").click()

# secure test case: the payload must not execute
assert "alert" not in driver.page_source

driver.quit()
print("Secure test case passed: XSS payload was not reflected.")
```

**Sample Output**
```
Secure test case passed: XSS payload was not reflected.
```
The assertion fails (test catches the vulnerability) if the app echoes the payload unescaped.

**Result:** An automated secure test case was written and run successfully, confirming the XSS payload is not reflected.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
