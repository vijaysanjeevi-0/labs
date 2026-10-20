# Ex 6.1 — ARP simulation (TCP)

**Aim:** Simulate ARP (IP → MAC lookup) using TCP sockets.

**Server:** `ServerSocket` on port 9139, keep a table of IP/MAC pairs, accept a client, receive an IP, look up the MAC and send it back (`Not found` if absent), then go back to listening.
**Client:** connect, read an IP from the user, send it, receive the MAC, display it, close.

```bash
javac *.java
java ServerArp         # terminal 1
java ClientArp         # terminal 2
```
```
Enter the Logical address(IP):
165.165.80.80
The Physical Address is: 6A:08:AA:C2
```

## What was fixed
`obj.close()` was inside `while(true)` and no reply was sent for an unknown IP, so the client hung; missing `;` and `)`. Port 139 (NetBIOS) is reserved on Windows, so 9139 is used. Sample MACs are 4 bytes as in the manual; real MAC addresses are 6 bytes (48 bits).
