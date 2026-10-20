# ex03 viva — GAE hello world

1. **What is Google App Engine?** A PaaS for deploying web apps without managing servers.
2. **What is `app.yaml` for?** Configuration: runtime, version and URL-to-script handler mappings.
3. **What does the `handlers` section do?** Routes incoming URL patterns to the script that should serve them.
4. **Local dev server vs deployment?** `dev_appserver.py` runs the app locally for testing; `gcloud app deploy` pushes it to the live App Engine service.
5. **Why Python 2.7 runtime in this (old) example?** The manual predates App Engine's newer standard runtimes (Python 3.x); the principle (handler → script) is unchanged.
