# Ex 3.3 — UDP chat

**Aim:** Two-way chat between a client and server using UDP datagrams.

**Algorithm — Server:** create a datagram socket (789), receive a request, if `end` stop, display it, read a reply from the keyboard, send it to the client (790), repeat.
**Algorithm — Client:** create a datagram socket (790), read a message, send to server (789), if `end` stop, otherwise receive and display the reply, repeat. The chat ends when the client sends `end`.

```bash
javac *.java
java UdpChatServer    # terminal 1
java UdpChatClient    # terminal 2
```

## What was fixed
`buffer = str.getBytes()` shrank the receive buffer, which truncated later messages (the manual's output shows "Hello Clie"). Each receive now uses a fresh 1024-byte buffer. `geyLocalHost` typo fixed; client always targets `localhost`.
