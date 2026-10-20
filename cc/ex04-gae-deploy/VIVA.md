# ex04 viva — GAE deploy

1. **What does `gcloud app deploy` do?** Uploads the app and its `app.yaml`/`index.yaml` to App Engine and creates a new version.
2. **What does `gcloud app browse` do?** Opens the deployed app's URL in the default browser.
3. **What is a datastore index, and why might deployment wait on it?** An index speeds up specific queries; new indexes must finish building before queries that need them succeed.
4. **What does the `-v` flag do?** Specifies a custom version ID for the deployment instead of an auto-generated one.
5. **What does the `--project` flag do?** Targets a specific Cloud project, overriding the gcloud default.
