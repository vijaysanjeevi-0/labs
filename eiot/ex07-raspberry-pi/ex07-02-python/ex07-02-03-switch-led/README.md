# Ex 7.2.3 — Switch-controlled LED (MicroPython)

**Aim:** Drive an LED from a push switch in MicroPython.

**Apparatus / Tools required:** Raspberry Pi Pico, Thonny, LED on GP16, push switch on GP15.

**Algorithm**
1. Configure GP16 as output and GP15 as input.
2. Read the switch; if pressed, blink the LED twice, else keep it off.
3. Repeat.

**Procedure:** open `switch_led.py`, run.

**Program**
```python
from machine import Pin
from time import sleep

led = Pin(16, Pin.OUT)
sw = Pin(15, Pin.IN)

while True:
    bt = sw.value()
    if bt == True:
        print("LED ON")
        led.value(1)
        sleep(2)
        led.value(0)
        sleep(2)
        led.value(1)
        sleep(2)
        led.value(0)
        sleep(2)
    else:
        print("LED OFF")
        sleep(0.5)
```

**Sample Output:** pressing the switch blinks the LED twice; otherwise the LED stays off.

**Result:** An LED was driven from a push switch using MicroPython successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
