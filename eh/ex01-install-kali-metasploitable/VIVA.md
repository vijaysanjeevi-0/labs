# ex01-install-kali-metasploitable viva — Installing Kali Linux / Metasploitable / Windows XP

1. **Why Host-Only networking instead of NAT/Bridged for this lab?** It isolates the vulnerable Metasploitable VM from the real network while still letting Kali reach it — safe for practising exploits.
2. **What is Metasploitable2?** A deliberately vulnerable Debian-based Linux VM, built to be attacked safely for training.
3. **Type 1 vs Type 2 hypervisor?** Type 1 runs directly on hardware (ESXi); Type 2 runs as an app on a host OS (VirtualBox).
4. **Why update Kali right after install (`apt update && upgrade`)?** To pull the latest tool versions and security patches before using it offensively.
5. **Why is Windows XP still used in a teaching lab?** It's unsupported and full of unpatched vulnerabilities, making it a simple legacy target for practising classic exploits.