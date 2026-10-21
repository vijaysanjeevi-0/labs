# Ex 8.1 — IR sensor

**Aim:** Interface an IR obstacle sensor with the Pico to drive a buzzer.

**Apparatus / Tools required:** Raspberry Pi Pico, IR sensor module, buzzer.

**Connections:** IR output -> GP15, buzzer -> GP16.

**Algorithm**
1. Configure the IR pin as input and the buzzer pin as output.
2. Read the IR sensor; if it indicates an obstacle (LOW), turn the buzzer on, else off.
3. Repeat.

**Procedure:** open `ir_sensor.py`, run.

**Program**
```python
from machine import Pin
from time import sleep

buzzer = Pin(16, Pin.OUT)
ir = Pin(15, Pin.IN)

while True:
    ir_value = ir.value()
    if ir_value == True:
        print("Buzzer OFF")
        buzzer.value(0)
    else:
        print("Buzzer ON")
        buzzer.value(1)
    sleep(0.5)
```

**Sample Output:** buzzer turns on when the IR sensor detects an obstacle, off otherwise.

**Result:** An IR sensor was interfaced with the Pico to drive a buzzer successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
