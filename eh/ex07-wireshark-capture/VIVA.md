# ex07-wireshark-capture viva — Network Traffic Capture using Wireshark

1. **What layer does Wireshark capture at?** The data-link layer (raw frames), then decodes up through to the application layer.
2. **Why does the FTP capture reveal the password in plain text?** FTP sends credentials unencrypted; anyone capturing the traffic on the path can read USER/PASS directly.
3. **What does 'Follow TCP Stream' do?** Reassembles all packets of one TCP connection into the readable request/response conversation.
4. **tshark vs Wireshark?** tshark is the command-line version of the same capture/analysis engine — scriptable, no GUI.
5. **How would you protect FTP traffic from this kind of capture?** Use an encrypted alternative (SFTP/FTPS) instead of plain FTP.