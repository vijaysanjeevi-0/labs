# Ex 3.2 — File transfer over TCP

**Aim:** Transfer a file from server to client over a TCP socket.

**Algorithm — Server:** create `ServerSocket(5000)`, accept the client, open the file, copy its bytes to the socket stream, close.
**Algorithm — Client:** connect, read bytes from the socket until end of stream, write them to the output file, close.

```bash
javac *.java
java FileServer somefile.html          # terminal 1
java FileClient received.html          # terminal 2
```

## What was fixed
Missing `;` after an import; hard-coded `e:\` paths replaced with command-line arguments. Verified byte-identical on a 55 KB file.
