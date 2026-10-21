# Ex 9 — Run a container from Docker Hub

**Aim:** To run a container from Docker Hub.

**Apparatus / Tools required:** Docker Desktop (or Docker Engine), internet access to Docker Hub.

**Algorithm**
1. Search Docker Hub for the desired image.
2. Pull (or let `run` auto-pull) the image.
3. Run a container from it, mapping a host port.

**Procedure**
```bash
docker search welcome-to-docker
docker pull docker/welcome-to-docker
docker run -d -p 8090:80 docker/welcome-to-docker
docker ps
```

**Program:** No program — pulls and runs a published image.

**Sample Output:** The container runs; the welcome page is served at `http://localhost:8090`.

**Result:** A container from Docker Hub was pulled and run successfully.
