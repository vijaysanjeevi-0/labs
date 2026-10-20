# Ex 4.2 viva — Arithmetic

1. **Range of `unsigned char`?** 0–255 (8 bits) — matches the 8051's 8-bit ports.
2. **Why assign results to P0–P3 instead of printing?** The 8051 has no console; port pins are the only visible output in hardware/simulator.
3. **What happens if a port value exceeds 255?** It wraps (truncates to 8 bits) since ports are single bytes.
4. **Which operator is integer division in C?** `/` for quotient, `%` for remainder.
5. **Why use REG51.H instead of hard-coded addresses?** It gives named, portable access to the SFRs instead of magic numbers.
