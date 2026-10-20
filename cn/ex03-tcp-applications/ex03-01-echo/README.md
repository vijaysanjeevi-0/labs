# Ex 3.1 — TCP Echo

**Aim:** Write a TCP echo client/server pair in Java.

**Algorithm — Server:** create `ServerSocket(9000)`, accept the client, copy everything received straight back to it, stop when the client disconnects.
**Algorithm — Client:** create a socket, connect to the server, read a line from the user, send it, read the echoed line back, display it, repeat until `end`, close.

```bash
javac *.java
java EchoServer       # terminal 1
java EchoClient       # terminal 2
```
```
Client: Hai Server
Server: Hai Server
Client: end
Socket closed
```

## What was fixed
`System.out.println(e)` was inside a `try` where `e` was not in scope, and the server looped forever after the client left. It now stops cleanly when the client disconnects.
