# Ex 8 — Creating and executing your first container using Docker

**Aim:** To create and execute your first container using Docker.

**Apparatus / Tools required:** Docker Desktop (or Docker Engine), a sample application with a Dockerfile.

**Algorithm**
1. Write a Dockerfile describing the base image and how to run the app.
2. Build an image from it.
3. Run a container from that image, mapping a host port to it.

**Procedure**
```bash
docker build -t myapp .
docker run -p 8089:8089 myapp
docker ps                 # confirm it's running
```

**Program**

`Dockerfile`
```dockerfile
FROM node:18-alpine
RUN mkdir -p /app
WORKDIR /app
COPY . .
CMD ["node", "index.js"]
```

**Sample Output:** The container starts and the app is reachable at `http://localhost:8089`.

**Result:** The first Docker container was created and executed successfully.
