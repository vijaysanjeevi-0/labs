# Ex 9.2 — Pico (slave/receiver)

**Tools:** Raspberry Pi Pico, Thonny, LED on GP16.

**Wiring:** Pico UART0 RX ← Arduino Tx (through a divider), shared GND.

**Run:** open `ex09-02-slave.py`, run, then power the Arduino.

**Expected output:** LED turns on when `A` is received, off when `B` is received; bytes are printed in the Thonny shell.
