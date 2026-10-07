# Ex 3 — Applications using sockets: Echo, Chat, File transfer

**Aim:** Write Java applications using TCP and UDP sockets.

Compile each subfolder with `javac *.java`. Always start the **server first**, each in its own terminal.

## A. TCP Echo (`echo/`, port 9000)
**Algorithm — Client:** create socket, connect to server, read a line from the user, send it, read the echoed line, display it, repeat until `end`, close.
**Algorithm — Server:** create `ServerSocket(9000)`, accept the client, copy everything received straight back to it, stop when the client disconnects.
```bash
java EchoServer       # terminal 1
java EchoClient       # terminal 2
```
```
Client: Hai Server
Server: Hai Server
Client: end
Socket closed
```

## B. UDP Chat (`udp-chat/`, ports 789 and 790)
**Algorithm — Client:** create datagram socket (790), read a message, send to server (789), if `end` stop, otherwise receive and display the reply, repeat.
**Algorithm — Server:** create datagram socket (789), receive a request, if `end` stop, display it, read a reply from the keyboard, send it to the client (790), repeat. The chat ends when the client sends `end`.
```bash
java UdpChatServer    # terminal 1
java UdpChatClient    # terminal 2
```

## C. File transfer (`file-transfer/`, port 5000)
**Algorithm — Server:** create `ServerSocket(5000)`, accept the client, open the file, copy the file to the socket stream, close.
**Algorithm — Client:** connect, read bytes from the socket until end of stream, write them to the output file, close.
```bash
java FileServer somefile.html          # terminal 1
java FileClient received.html          # terminal 2
```

## What was fixed
- Echo: `System.out.println(e)` was inside a `try` where `e` is not in scope. The server looped forever after the client left. It now stops when the client disconnects.
- UDP chat: `buffer = str.getBytes()` shrank the receive buffer, which truncated later messages (the manual's output shows "Hello Clie"). Each receive now uses a fresh 1024-byte buffer. The client is always `localhost`. `geyLocalHost` typo fixed.
- File transfer: missing `;` after an import; hard-coded `e:\` paths replaced with command-line arguments; the % progress prints were dropped to keep it short. Verified byte-identical on a 55 KB file.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
