# Ex 2 — HTTP web client using TCP sockets

**Aim:** Write a Java HTTP client that downloads a web page over a TCP socket.

## Algorithm
**Client**
1. Start.
2. Create a TCP socket to the web server (host, port 80).
3. Send an HTTP request: `GET <path> HTTP/1.0`, `Host: <host>`, blank line.
4. Read the response until the server closes the connection.
5. Split the status line and headers from the body at the blank line (`\r\n\r\n`).
6. Save the body to `downloaded.html`.
7. Close the socket. Stop.


## Run
```bash
cd src && javac *.java

# offline test: two terminals
python3 -m http.server 8080              # terminal 1 (any local web server works)
java HttpClient localhost 8080           # terminal 2

# real site (plain HTTP only, no HTTPS)
java HttpClient example.com
```

## Expected output
```
HTTP/1.0 200 OK
```
The page body is saved to `downloaded.html`.

## What changed from the manual
The manual's program transferred an image over a raw socket, which is not HTTP and does not match the title. This version speaks real HTTP/1.0 (so no chunked encoding) and always requests `/`. No custom server is needed: `python3 -m http.server` serves the test page. HTTPS needs TLS (`SSLSocket`) and is out of scope.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
