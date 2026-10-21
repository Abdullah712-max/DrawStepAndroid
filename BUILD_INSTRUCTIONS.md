# Building DrawStep with only an Android phone

1. In your GitHub repo, create `.github/workflows/build.yml` (paste the provided build.yml).
2. Upload `drawstep-project.zip` to the repo root (Add file > Upload files). Commit.
3. Open the Actions tab. The workflow unpacks the ZIP, commits the files, builds, and runs tests.
4. When it finishes, open the run and download the artifact `DrawStep-debug-apk`.
5. Unzip it on your phone and install `app-debug.apk` (allow installs from your browser/Files app when asked).
6. If a run fails, open the failed step in the logs and send me the last ~40 lines.

Later edits: open a file on GitHub, tap the pencil icon, edit, commit. Then Actions > Build DrawStep debug APK > Run workflow.
