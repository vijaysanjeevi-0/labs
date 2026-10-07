# Ex 4 — Simulation of DNS using UDP sockets

**Aim:** Write a Java program that simulates DNS name-to-IP resolution over UDP.

## Algorithm
**Server**
1. Start. Create a UDP datagram socket on port 1362.
2. Create a table mapping host names to IP addresses.
3. Receive a host name from a client.
4. Get the client's address and port from the datagram.
5. Look the host name up in the table (`Host Not Found` if absent).
6. Display the request and send the IP address back to the client.
7. Repeat from step 3.

**Client**
1. Start. Create a UDP datagram socket.
2. Read the host name from the user.
3. Send it to the server.
4. Wait for the reply datagram.
5. Display the IP address. Stop.

## Run
```bash
cd src && javac *.java
java UdpDnsServer                    # terminal 1
java UdpDnsClient                    # terminal 2
```

## Expected output
```
Enter the hostname : yahoo.com
IP Address: 68.180.206.184
Enter the hostname : cricinfo.com
IP Address: 80.168.92.140
Enter the hostname : youtube.com
IP Address: Host Not Found
```

## What was fixed
The server created a new `DatagramSocket(1362)` inside the loop, and compared the whole 1021-byte buffer instead of only the received bytes (now only the received length is used). The client had a mangled `else ipaddress,portaddr);` line and `Senddata` (capital S).

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
