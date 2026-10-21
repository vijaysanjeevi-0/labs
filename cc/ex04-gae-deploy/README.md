# Ex 4 — Use the GAE launcher to launch the web application

**Aim:** To use the GAE launcher to launch the web applications.

**Apparatus / Tools required:** Google Cloud SDK (`gcloud`), a Google Cloud project, the app from ex03.

**Algorithm**
1. Point `gcloud` at the project containing the app's `app.yaml`.
2. Deploy the app to App Engine.
3. Open the deployed app's URL.

**Procedure**
```bash
gcloud app deploy app.yaml index.yaml
# optional flags:
#   --project YOUR_PROJECT_ID   use a non-default Cloud project
#   -v YOUR_VERSION_ID          pin a specific version ID
gcloud app browse
```

**Program:** No new program — reuses `app.yaml`/`index.py` from `ex03-gae-hello-world/`. The relevant `app.yaml` fields:
```yaml
runtime: python27
api_version: 1
threadsafe: false
handlers:
  - url: /
    script: index.py
```

**Sample Output:** The app is reachable at `https://PROJECT_ID.REGION_ID.r.appspot.com`.

**Result:** The GAE launcher was used to deploy and launch the web application successfully.
