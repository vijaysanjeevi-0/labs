# Ex 4.1 — LED blink (Embedded C)

**Aim:** Blink an LED on P2.0 using Embedded C.

**Apparatus / Tools required:** Keil uVision, AT89C51, `REG51.H`.

**Algorithm**
1. Declare P2.0 as a bit variable (`sbit`).
2. In an infinite loop: set it low, delay, set it high, delay.

**Procedure:** build `led_blink.c`, run in the simulator, watch P2.0 in Peripherals > I/O Ports.

**Program**
```c
#include <REG51.H>

sbit LED = P2^0;

void main() {
    unsigned int j;
    while (1) {
        LED = 0;
        for (j = 0; j < 10000; j++);
        LED = 1;
        for (j = 0; j < 10000; j++);
    }
}
```

**Sample Output:** P2.0 toggles between 0 and 1.

**Result:** An LED blink program was written in Embedded C and run successfully on the 8051 simulator.

## Notes
The record's aim mentions P0.0, but its own code drives P2.0; the code is kept as the record wrote it.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
