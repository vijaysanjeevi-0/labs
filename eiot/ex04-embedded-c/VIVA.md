# Viva: ex04-embedded-c

**Q1. What is sbit?**
A Keil keyword that names a single bit of a bit-addressable SFR or RAM.

**Q2. Why while(1) in embedded programs?**
There is no OS to return to, so main must never exit.

**Q3. Why is a software delay not accurate?**
It depends on compiler optimisation and clock; a timer gives exact delays.

**Q4. What does REG51.H define?**
The 8051 SFR names such as P0-P3, TMOD, TCON.

**Q5. unsigned char range?**
0-255 (8 bits).
