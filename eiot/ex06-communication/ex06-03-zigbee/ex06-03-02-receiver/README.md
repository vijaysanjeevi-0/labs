# Ex 6.3.2 — Zigbee receiver

**Tools:** Arduino IDE 2.0, Arduino UNO, Zigbee module, jumper wires, LED.

**Connections**

| Arduino UNO pin | Zigbee module |
|---|---|
| 5V | 5V |
| GND | G |
| 2 | Tx |
| 3 | Rx |

LED on pin 4.

**Run:** open `ex06-03-02-receiver/ex06-03-02-receiver.ino`, upload, power the transmitter.

**Expected output:** LED turns on when `A` is received, off when `B` is received.
