# Ex 3 viva — echo, chat, file transfer

1. **Difference between `Socket` and `ServerSocket`?** `ServerSocket` listens and `accept()`s connections; `Socket` is the connected endpoint used to send and receive.
2. **What does `accept()` do?** Blocks until a client connects, then returns a new `Socket` for that client.
3. **Why start the server first?** A TCP client's `connect` fails if nothing is listening on that port.
4. **What is an echo server for?** Testing connectivity and demonstrating the request/response model: it returns what it receives.
5. **TCP stream vs UDP datagram?** TCP is a continuous byte stream with no message boundaries; UDP delivers separate messages (datagrams).
6. **Why must UDP chat use fresh buffers?** Reusing a shortened buffer truncates the next message (the "Hello Clie" bug).
7. **Why do UDP client and server use different ports on one machine?** Two sockets on one host cannot bind the same UDP port.
8. **Is UDP chat reliable?** No: datagrams may be lost, duplicated or reordered, and nothing retransmits.
9. **How does the file client know the file ended?** The server closes the socket, so `read` returns -1 (end of stream).
10. **How to serve many clients?** One thread (or process) per accepted connection.
11. **Full duplex?** TCP carries data in both directions at the same time.
12. **What does `DatagramPacket` hold?** Data buffer, length, and the destination (or source) address and port.
