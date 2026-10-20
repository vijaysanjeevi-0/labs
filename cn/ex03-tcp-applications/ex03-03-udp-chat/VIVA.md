# Ex 3.3 viva — UDP chat

1. **TCP stream vs UDP datagram?** TCP is a continuous byte stream with no message boundaries; UDP delivers separate, bounded messages (datagrams).
2. **Why must UDP chat use fresh buffers?** Reusing a shortened buffer truncates the next message (the "Hello Clie" bug).
3. **Why do client and server use different ports on one machine?** Two sockets on one host cannot bind the same UDP port.
4. **Is UDP chat reliable?** No: datagrams may be lost, duplicated or reordered, and nothing retransmits.
5. **What does `DatagramPacket` hold?** A data buffer, its length, and the destination (or source) address and port.
