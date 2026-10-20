# Ex 4.1 viva — LED blink

1. **What is `sbit`?** A Keil keyword that names a single bit of a bit-addressable SFR or RAM byte.
2. **Why `while(1)` in embedded programs?** There is no OS to return to, so `main` must never exit.
3. **Why is a software delay loop not accurate?** It depends on compiler optimisation and the clock speed; a hardware timer gives an exact delay.
4. **What does `REG51.H` define?** The 8051 SFR names such as P0–P3, TMOD and TCON.
5. **How would you make the blink rate exact?** Use Timer0/1 in the 8051 to generate a fixed interval instead of a `for` loop.
