# Ex 2 viva — HTTP client with TCP sockets

1. **What is HTTP?** Application-layer request/response protocol of the web; runs over TCP port 80.
2. **Why TCP for HTTP?** Web pages need reliable, ordered delivery.
3. **Is HTTP stateless?** Yes, each request is independent; cookies/sessions add state.
4. **Common methods?** GET (fetch), POST (send data), PUT, DELETE, HEAD.
5. **Common status codes?** 200 OK, 301 moved permanently, 404 not found, 500 server error.
6. **Structure of a request?** Request line, headers, blank line (`\r\n\r\n`), optional body.
7. **Why is the `Host` header needed?** One IP can host many websites; Host says which one.
8. **HTTP/1.0 vs 1.1?** 1.0 closes the connection after each response; 1.1 keeps it open (persistent) and supports chunked transfer. This program uses 1.0 so the response ends when the server closes.
9. **HTTP vs HTTPS?** HTTPS is HTTP over TLS (port 443): encrypted and authenticated.
10. **How does the client know where the headers end?** At the first blank line (`\r\n\r\n`).
11. **What is a URL?** `scheme://host:port/path?query`.
