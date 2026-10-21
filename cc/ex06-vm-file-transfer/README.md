# Ex 6 — File transfer between virtual machines

**Aim:** To find a procedure to transfer files from one virtual machine to another virtual machine.

**Apparatus / Tools required:** Two VMs on the same hypervisor, VirtualBox Guest Additions, (optionally) `ssh`/`scp`.

**Algorithm**
1. Pick a transfer channel: shared clipboard, shared folder, or a network copy (scp/NFS/Samba).
2. Enable it on both guest VMs.
3. Copy a file through that channel and confirm it appears on the other VM.

**Procedure**
```
# Option 1 - shared clipboard (small snippets)
Install Guest Additions on both VMs -> Settings -> General -> Advanced ->
Shared Clipboard: Bidirectional

# Option 2 - shared folder (whole files)
Settings -> Shared Folders -> add a host folder, mark Auto-mount
Both VMs read/write that folder directly.

# Option 3 - scp between two VMs over the host-only/NAT network
sudo apt-get install openssh-server     # on the receiving VM
pgrep sshd                              # confirm it's running
scp file.txt user@<vm-ip>:/home/user/   # from the sending VM
```

**Program:** No program — this is a VM/host configuration procedure.

**Result:** A file was transferred from one virtual machine to another successfully using a shared folder / scp.
