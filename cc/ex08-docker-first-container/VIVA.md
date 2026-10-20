# ex08 viva — First Docker container

1. **Image vs container?** An image is a read-only template/snapshot; a container is a running (or stopped) instance created from that image.
2. **What does `docker build -t name .` do?** Builds an image from the Dockerfile in the current directory and tags it `name`.
3. **What does `FROM node:18-alpine` mean?** The image is built on top of the official Node.js 18 image using the lightweight Alpine Linux base.
4. **Why publish a port with `-p`?** To map a container-internal port to a port on the host so it is reachable from outside.
5. **How is a container different from the image it ran from, after it stops?** It keeps its own writable filesystem layer (changes made while running) separate from the original image.
