# ex06 viva — VM file transfer

1. **What are VirtualBox Shared Folders?** A host directory mounted inside the guest so both can read/write the same files.
2. **Why is shared clipboard not file transfer?** It only moves small text/snippets interactively; it is not meant for whole files.
3. **What is scp?** Secure copy — transfers files between hosts over SSH.
4. **Why must sshd run on the receiving machine for scp?** scp needs an SSH server listening to accept the incoming connection and authenticate it.
5. **What issue can shared folders have across guest OSes?** File timestamp/clock mismatches if the VMs have different date/time settings.
