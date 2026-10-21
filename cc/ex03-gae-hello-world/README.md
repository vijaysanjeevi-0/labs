# Ex 3 — Google App Engine: hello world

**Aim:** To create a hello-world app and other simple web applications using Python/Java on Google App Engine.

**Apparatus / Tools required:** Python, Google App Engine SDK (`dev_appserver.py`), a text editor.

**Algorithm**
1. Create a project folder for the app.
2. Write `app.yaml`, mapping every URL to a handler script.
3. Write the handler script (`index.py`) to print the response.
4. Run the local dev server and open it in a browser.

**Procedure**
```bash
dev_appserver.py app.yaml
# open http://localhost:8080/
```

**Program**

`app.yaml`
```yaml
application: ae-01-trivial
version: 1
runtime: python27
api_version: 1
handlers:
  - url: /.*
    script: index.py
```

`index.py`
```python
print('Content-Type: text/plain')
print('')
print('Hello there Chuck')
```

**Sample Output**
```
Content-Type: text/plain

Hello there Chuck
```

**Result:** Google App Engine was installed and the hello-world application was created and run successfully.
