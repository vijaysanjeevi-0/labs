# Ex 4.2 — Arithmetic (Embedded C)

**Aim:** Perform arithmetic operations in Embedded C and write results to ports.

**Apparatus / Tools required:** Keil uVision, AT89C51, `REG51.H`.

**Algorithm**
1. Declare two operands.
2. Compute their difference, sum, product and quotient.
3. Write each result to a separate port (P0-P3).

**Procedure:** build `arithmetic.c`, run in the simulator, watch P0-P3.

**Program**
```c
#include <REG51.H>

void main() {
    unsigned char a = 0x10, b = 0x04;
    P0 = a - b;
    P1 = a + b;
    P2 = a * b;
    P3 = a / b;
    while (1);
}
```

**Sample Output:** `P0 = 0x0C` (12), `P1 = 0x14` (20), `P2 = 0x40` (64), `P3 = 0x04` (4), for `a=0x10, b=0x04`.

**Result:** Arithmetic operations were performed in Embedded C and their results displayed on the ports successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
