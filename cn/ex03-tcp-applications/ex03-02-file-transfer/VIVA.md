# Ex 3.2 viva — File transfer

1. **How does the client know the file ended?** The server closes the socket, so `read` returns -1 (end of stream).
2. **Why read in a loop instead of one big read?** TCP is a byte stream with no message boundaries; a single `read` may return fewer bytes than requested.
3. **Text vs binary transfer?** This uses raw byte streams, so it works for both; a `Reader`/`Writer` would corrupt binary files.
4. **What happens if the server file doesn't exist?** `FileNotFoundException` is thrown before anything is sent.
5. **How would you show transfer progress?** Track bytes copied against the file size (or `Content-Length` if sent first) and print a running percentage.
