# ex08 - First Docker container

## Aim
Build and run your first container.

## Run
```
docker build -t myapp .
docker run -p 8089:8089 myapp
```

## Output
Container starts and the app is reachable on the mapped port.
