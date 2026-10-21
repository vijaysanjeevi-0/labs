# Ex 7.2.2 — RGB LED cycle (MicroPython)

**Aim:** Cycle red, yellow and green LEDs in MicroPython.

**Apparatus / Tools required:** Raspberry Pi Pico, Thonny, LEDs on GP16 (red), GP17 (yellow), GP18 (green).

**Algorithm**
1. Configure the three pins as output.
2. In an infinite loop: turn red on, wait, off; turn yellow on, wait, off; turn green on, wait, off.

**Procedure:** open `rgb.py`, run.

**Program**
```python
from machine import Pin
from time import sleep_ms, sleep

r = Pin(16, Pin.OUT)
y = Pin(17, Pin.OUT)
g = Pin(18, Pin.OUT)

while True:
    r.value(1)
    sleep_ms(1000)
    r.value(0)
    sleep_ms(1000)
    y.value(1)
    sleep(1)
    y.value(0)
    sleep(1)
    g.value(1)
    sleep(1)
    g.value(0)
    sleep(1)
```

**Sample Output:** red, then yellow, then green LED, each on for about 1 second, repeating.

**Result:** The red, yellow and green LEDs were cycled in sequence successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
