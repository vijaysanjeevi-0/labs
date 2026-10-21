# Ex 7.2.1 — LED blink (MicroPython)

**Aim:** Write a basic MicroPython program to blink an LED.

**Apparatus / Tools required:** Raspberry Pi Pico, Thonny, LED on GP16.

**Algorithm**
1. Configure GP16 as output.
2. In an infinite loop: set it high, wait 1 s, set it low, wait 1 s.

**Procedure:** open `led.py` in Thonny with the MicroPython (Pico) interpreter selected, run.

**Program**
```python
from machine import Pin
import time

LED = Pin(16, Pin.OUT)

while True:
    LED.value(1)
    time.sleep(1)
    LED.value(0)
    time.sleep(1)
```

**Sample Output:** LED blinks every second.

**Result:** An LED was blinked using MicroPython on the Pico successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
