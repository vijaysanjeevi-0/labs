# Viva: ex09-arduino-pico

**Q1. What is UART?**
Asynchronous serial: start bit, data bits, stop bit, no shared clock.

**Q2. Why must baud rates match?**
Without a clock the receiver samples by timing.

**Q3. Why share GND?**
Both boards need a common voltage reference.

**Q4. What is the logic-level issue?**
UNO is 5 V, Pico is 3.3 V and can be damaged by 5 V.

**Q5. str vs bytes in MicroPython?**
UART returns bytes, so compare with b'' literals.
