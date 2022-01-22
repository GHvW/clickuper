# clickuper

ClickUper is a small command line utility to do things in ClickUp


### Add a checklist

```bash
$ node clickuper.js task-id checklist.txt
```


## Development

```bash
$ npx shadow-cljs watch app
```

## Release Build

run

```bash
$ npx shadow-cljs release app
```

the script can be found at `<root>/dist/clickuper.js`
