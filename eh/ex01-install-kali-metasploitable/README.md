# Ex 01 — Installing Kali Linux / Metasploitable / Windows XP

**Aim:** To set up the ethical hacking lab environment by installing Kali Linux, Metasploitable, and Windows XP virtual machines.

**Apparatus / Tools required:** Oracle VirtualBox or VMware Workstation, Kali Linux ISO, Metasploitable2 VM image, Windows XP ISO (for legacy testing).

**Algorithm**
1. Install a Type-2 hypervisor (VirtualBox) on the host.
2. Create a VM, attach the Kali ISO, and run the guided installer.
3. Import the pre-built Metasploitable2 OVA as a second VM.
4. Set both VMs' network adapters to Host-Only so they can reach each other but stay isolated from the internet/host LAN.
5. (Optional) Create a third VM for Windows XP the same way, for legacy-OS testing.

**Procedure / Commands (in order)**
```
# 1. Download & install VirtualBox from virtualbox.org
# 2. VirtualBox -> New -> Name: Kali, Type: Linux, Version: Debian 64-bit
#    RAM >= 2 GB, disk >= 20 GB (dynamic)
# 3. Settings -> Storage -> mount the Kali ISO, then Start -> run the installer
#    (language, time zone, "use entire disk", set root password)
sudo apt update && sudo apt upgrade -y        # after first boot

# 4. Import Metasploitable2
# VirtualBox -> File -> Import Appliance -> select the downloaded .ova

# 5. Set both Kali and Metasploitable adapters to "Host-only Adapter"
#    (Settings -> Network -> Attached to: Host-only Adapter)

# 6. Verify connectivity from Kali
ping 192.168.56.102          # Metasploitable's host-only IP
```

**Program:** No custom program — this experiment uses tool/CLI commands only, run in the order above.

**Sample Output**
```
root@kali:~# uname -a
Linux kali 6.1.0-kali9-amd64 #1 SMP Debian 6.1.27-1kali1 x86_64 GNU/Linux
root@kali:~# ifconfig eth0
eth0: flags=4163 mtu 1500
        inet 192.168.56.101 netmask 255.255.255.0 broadcast 192.168.56.255
```

**Result:** Kali Linux and Metasploitable2 were installed, networked on a host-only adapter, and confirmed reachable from each other.
