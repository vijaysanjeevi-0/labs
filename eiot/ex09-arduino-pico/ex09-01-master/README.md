# Ex 9.1 — Arduino (master/sender)

**Tools:** Arduino IDE 2.0, Arduino UNO, jumper wires.

**Wiring:** UNO pin 3 (Tx) → Pico UART0 RX; share GND. Use a level shifter/divider (UNO is 5 V, Pico is 3.3 V).

**Run:** open `ex09-01-master/ex09-01-master.ino`, upload.

**Expected output:** sends `A` then `B`, 1 second apart, continuously.
