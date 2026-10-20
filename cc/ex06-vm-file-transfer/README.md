# ex06 - File transfer between VMs

No program — host/guest mechanism only.

## Aim
Transfer files from one VM to another.

## Methods
1. Shared clipboard (Guest Additions, bidirectional).
2. Shared folder (Settings > Shared Folders).
3. `scp`/`sshd` between the two guests.
4. Mount via NFS/SSHFS/Samba.

## Result
A file created on one VM is visible/copied to the other.
