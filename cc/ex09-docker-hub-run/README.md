# ex09 - Run a container from Docker Hub

No new program — pulls a published image.

## Run
```
docker search welcome-to-docker
docker pull docker/welcome-to-docker
docker run -d -p 8088:80 docker/welcome-to-docker
```

## Output
Container runs; the welcome page is served on the mapped port.
