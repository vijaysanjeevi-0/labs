# Ex 8.2 — Ultrasonic sensor

**Aim:** Measure distance with an HC-SR04 ultrasonic sensor on the Pico and drive a buzzer.

**Apparatus / Tools required:** Raspberry Pi Pico, HC-SR04, buzzer, resistor divider on Echo (5V -> 3.3V).

**Connections:** Trigger -> GP14, Echo -> GP15 (via divider), buzzer -> GP16.

**Algorithm**
1. Pulse the trigger pin high for 10 microseconds.
2. Measure how long the echo pin stays high.
3. Convert that time to distance using the speed of sound.
4. If distance <= 10 cm, turn the buzzer on, else off. Repeat.

**Procedure:** open `ultrasonic.py`, run.

**Program**
```python
from machine import Pin
import utime

trigger = Pin(14, Pin.OUT)
echo = Pin(15, Pin.IN)
buzzer = Pin(16, Pin.OUT)


def measure_distance():
    trigger.low()
    utime.sleep_us(2)
    trigger.high()
    utime.sleep_us(5)
    trigger.low()
    while echo.value() == 0:
        signaloff = utime.ticks_us()
    while echo.value() == 1:
        signalon = utime.ticks_us()
    timepassed = signalon - signaloff
    return (timepassed * 0.0343) / 2


while True:
    dist = measure_distance()
    print(f"Distance : {dist} cm")
    if dist <= 10:
        buzzer.value(1)
    else:
        buzzer.value(0)
    utime.sleep(0.5)
```

**Sample Output:** distance printed in cm every ~0.5 s; buzzer turns on when distance <= 10 cm.

**Result:** Distance was measured with the ultrasonic sensor and used to control a buzzer successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
