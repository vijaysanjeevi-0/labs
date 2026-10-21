# Ex 6.3.1 — Zigbee transmitter

**Aim:** Send commands over a Zigbee link.

**Apparatus / Tools required:** Arduino IDE 2.0, Arduino UNO, Zigbee module, jumper wires.

**Connections**

| Arduino UNO pin | Zigbee module |
|---|---|
| 5V | VCC |
| GND | G |
| 2 | Tx |
| 3 | Rx |

**Algorithm**
1. Open a SoftwareSerial port to the Zigbee module.
2. Send `A`, wait 100 ms.
3. Send `B`, wait 100 ms.
4. Repeat.

**Procedure:** open `ex06-03-01-transmitter/ex06-03-01-transmitter.ino`, upload.

**Program**
```cpp
#include <SoftwareSerial.h>

SoftwareSerial mySerial(2, 3);  // RX, TX

void setup() {
  mySerial.begin(9600);
  Serial.begin(9600);
}

void loop() {
  mySerial.write('A');
  Serial.println('A');
  delay(100);
  mySerial.write('B');
  Serial.println('B');
  delay(100);
}
```

**Sample Output:** the board sends `A` then `B` repeatedly, 100 ms apart.

**Result:** Commands were sent over a Zigbee link from the transmitter Arduino successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
