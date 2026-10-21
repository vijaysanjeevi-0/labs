# Ex 9.2 — Pico (slave/receiver)

**Aim:** Receive commands from an Arduino over UART on the Pico and drive an LED.

**Apparatus / Tools required:** Raspberry Pi Pico, Thonny, LED on GP16.

**Wiring:** Pico UART0 RX <- Arduino Tx (through a divider), shared GND.

**Algorithm**
1. Open UART0 at 9600 baud.
2. If bytes are available, read them.
3. If the data contains `A`, turn the LED on; if `B`, turn it off.
4. Repeat.

**Procedure:** open `ex09-02-slave.py`, run, then power the Arduino.

**Program**
```python
from machine import Pin, UART

uart = UART(0, 9600)
led = Pin(16, Pin.OUT)

while True:
    if uart.any() > 0:
        data = uart.read()
        print(data)
        if b"A" in data:
            led.value(1)
            print("LED on \n")
            uart.write("LED on \n")
        elif b"B" in data:
            led.value(0)
            print("LED off \n")
            uart.write("LED off \n")
```

**Sample Output:** LED turns on when `A` is received, off when `B` is received; bytes are printed in the Thonny shell.

**Result:** Commands sent by the Arduino were received over UART on the Pico and used to control an LED successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
