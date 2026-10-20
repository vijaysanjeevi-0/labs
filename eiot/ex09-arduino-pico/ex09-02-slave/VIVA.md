# Ex 9.2 viva — Pico slave

1. **Why `b"A" in data` and not `"A" in data`?** `uart.read()` returns a `bytes` object in MicroPython; comparing against a `str` raises a `TypeError`.
2. **What does `UART(0, 9600)` configure?** UART peripheral 0 at 9600 baud, using the Pico's default UART0 pins.
3. **Why check `uart.any() > 0` before reading?** It tells you bytes are waiting, avoiding a read that returns nothing.
4. **What happens if multiple bytes arrive before you read?** `uart.read()` can return more than one byte at once; `in` still finds the substring.
5. **How would you make this bidirectional?** Also call `uart.write()` from the Pico and read the Arduino's serial input on its receiving pin.
