# ex05 - Secure test cases (Selenium)

## Aim
Write an automated secure test case that checks an XSS payload is *not* reflected.

## Run
```
pip install selenium
python test_login_xss.py
```

## Output
```
Secure test case passed: XSS payload was not reflected.
```
The assertion fails (test catches the vulnerability) if the app echoes the payload unescaped.
