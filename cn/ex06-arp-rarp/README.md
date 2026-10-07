# Ex 6 — Simulation of ARP / RARP

**Aim:** Simulate ARP (IP → MAC) using TCP sockets and RARP (MAC → IP) using UDP sockets in Java.

## A. ARP over TCP (`arp/`, port 9139)
**Client**
1. Start. Create a socket and connect to the server.
2. Read the IP address from the user and send it.
3. Receive the MAC address and display it.
4. Close the connection. Stop.

**Server**
1. Start. Create a `ServerSocket`, listen.
2. Keep a table of IP and MAC addresses.
3. Accept a client, receive the IP address.
4. Look up the MAC and send it (`Not found` if absent).
5. Close the connection and go back to listening.

```bash
cd arp && javac *.java
java ServerArp         # terminal 1
java ClientArp         # terminal 2
```
```
Enter the Logical address(IP):
165.165.80.80
The Physical Address is: 6A:08:AA:C2
```

## B. RARP over UDP (`rarp/`, port 1309)
**Client:** create a datagram socket, read the MAC from the user, send it, receive the datagram, display the IP.
**Server:** create a datagram socket, keep the IP/MAC table, receive a MAC, look up the IP, send it back (`Not found` if absent).

```bash
cd rarp && javac *.java
java ServerRarp        # terminal 1
java ClientRarp        # terminal 2
```
```
Enter the Physical address (MAC):
6A:08:AA:C2
The Logical Address is(IP): 165.165.80.80
```

## What was fixed
- ARP server: `obj.close()` was inside `while(true)` and no reply was sent for an unknown IP, so the client hung. Port 139 (NetBIOS) is reserved on Windows, so 9139 is used.
- ARP client: missing `;` and `)`.
- RARP server: `break` before `sendbyte=...` made the send code unreachable. RARP client: mangled braces.
- The sample MACs are 4 bytes as in the manual; real MAC addresses are 6 bytes (48 bits). Change the tables if you want realistic values.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
