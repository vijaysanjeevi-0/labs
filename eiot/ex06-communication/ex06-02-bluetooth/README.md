# Ex 6.2 — Bluetooth communication

**Aim:** Control an LED over Bluetooth using an HC-05 module.

**Tools:** Arduino IDE 2.0, Arduino UNO, HC-05 Bluetooth module, jumper wires.

**Connections**

| Arduino UNO pin | HC-05 |
|---|---|
| 5V | VCC |
| GND | GND |
| 2 | Tx |
| 3 | Rx |

LED on pin 4.

**Run:** open `ex06-02-bluetooth/ex06-02-bluetooth.ino`, upload, pair the phone with the HC-05, open a Bluetooth terminal app, send `1` or `2`.

**Expected output:** LED turns on for `1`, off for `2`.
