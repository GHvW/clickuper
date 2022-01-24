# clickuper

ClickUper is a small command line utility to do things in ClickUp

At [Halff](https://www.halff.com/), we use a "Dev Test" checklist in ClickUp to let our code reviewer know how to test our application changes. The process is a hassle in the ClickUp app because of some weird syncing issues when you add items. I decided it would be easier to write the checklist in a text document and then transfer it to ClickUp.

ClickUper attempts to automate as much of that process as possible. 



## Builds + Run

ClickUper relies on the existence of 3 environment variables:
1. CLICKUP_API_TOKEN - your personal auth token
2. CLICKUP_USER_ID - your user Id
3. CLICKUP_WORKSPACE_ID - your workspace/team Id

After running any of the builds, the script can be found at `<root>/dist/clickuper.js`

Find the set of commands by running 
```bash
$ node <root>/dist/clickuper.js -h
```

ClickUper is built using [shadow-cljs](https://github.com/thheller/shadow-cljs). 

You can install the tool globally, or prefix each of the `npm` scripts in the `package.json` with `npx`, e.g. `shadow-cljs compile app` becomes `npx shadow-cljs compile app`

### Development
The dev build will watch the app for code changes and hot-reload as you make them.

```bash
$ npm run dev
```

While watched, you can run the app.

### Release
While probably not necessary, you can create a release build using the release script
```bash
$ npm run build:release
```

