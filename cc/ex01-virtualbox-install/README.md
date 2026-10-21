# Ex 1 — Install VirtualBox/VMware with a guest OS

**Aim:** To install VirtualBox/VMware Workstation with different flavours of Linux or Windows OS on top of the host OS.

**Apparatus / Tools required:** VirtualBox (or VMware Workstation), a guest OS ISO (e.g. Ubuntu), host machine with virtualization (VT-x) enabled in BIOS.

**Algorithm**
1. Install the hypervisor on the host.
2. Create a new VM: name, OS type/version, RAM, virtual disk.
3. Attach the guest OS ISO as the VM's optical drive.
4. Boot the VM and run the guest installer.
5. Reboot into the installed guest OS.

**Procedure**
```
1. Download VirtualBox for the host OS and install it with defaults.
2. VirtualBox -> New -> name the VM; VirtualBox auto-detects Type/Version from the name.
3. Set RAM (leave enough for the host) and create a virtual hard disk (VDI, dynamically
   allocated or fixed size for better performance).
4. Settings -> System -> increase CPU count if the guest OS can use multiple cores.
5. Settings -> Storage -> attach the guest ISO to the optical drive.
6. Start the VM -> follow the installer (language, time zone, "erase disk and install",
   create a user account).
7. After install, remove the ISO and restart the VM into the new OS.
```

**Program:** No program — VirtualBox GUI installation only.

**Sample Output:** A working guest OS desktop, reachable in the VirtualBox window.

**Result:** VirtualBox was installed and a guest OS was created, installed and run successfully on top of the host OS.
