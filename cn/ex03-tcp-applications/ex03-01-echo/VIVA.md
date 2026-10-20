# Ex 3.1 viva — TCP Echo

1. **Difference between `Socket` and `ServerSocket`?** `ServerSocket` listens and `accept()`s connections; `Socket` is the connected endpoint used to send and receive.
2. **What does `accept()` do?** Blocks until a client connects, then returns a new `Socket` for that client.
3. **Why start the server first?** A TCP client's `connect` fails if nothing is listening on that port.
4. **What is an echo server for?** Testing connectivity and demonstrating the request/response model: it returns what it receives.
5. **How does the client know to stop?** It sends `end` as a sentinel and closes its own socket.
