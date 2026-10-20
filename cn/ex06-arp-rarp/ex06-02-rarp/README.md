# Ex 6.2 — RARP simulation (UDP)

**Aim:** Simulate RARP (MAC → IP lookup) using UDP sockets.

**Server:** datagram socket on port 1309, keep the IP/MAC table, receive a MAC, look up the IP, send it back (`Not found` if absent).
**Client:** datagram socket, read the MAC from the user, send it, receive the datagram, display the IP.

```bash
javac *.java
java ServerRarp        # terminal 1
java ClientRarp        # terminal 2
```
```
Enter the Physical address (MAC):
6A:08:AA:C2
The Logical Address is(IP): 165.165.80.80
```

## What was fixed
A `break` before `sendbyte=...` made the send code unreachable in the server; mangled braces in the client.
