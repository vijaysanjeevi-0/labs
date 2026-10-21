# Ex 6.3.2 — Zigbee receiver

**Aim:** Receive commands over a Zigbee link and drive an LED.

**Apparatus / Tools required:** Arduino IDE 2.0, Arduino UNO, Zigbee module, jumper wires, LED.

**Connections**

| Arduino UNO pin | Zigbee module |
|---|---|
| 5V | 5V |
| GND | G |
| 2 | Tx |
| 3 | Rx |

LED on pin 4.

**Algorithm**
1. Open a SoftwareSerial port to the Zigbee module.
2. If a byte is available, read it.
3. If it is `A`, turn the LED on; if `B`, turn it off.

**Procedure:** open `ex06-03-02-receiver/ex06-03-02-receiver.ino`, upload, power the transmitter.

**Program**
```cpp
#include <SoftwareSerial.h>

SoftwareSerial mySerial(2, 3);  // RX, TX

void setup() {
  mySerial.begin(9600);
  Serial.begin(9600);
  pinMode(4, OUTPUT);
}

void loop() {
  if (mySerial.available() > 0) {
    char data = mySerial.read();
    Serial.println(data);
    if (data == 'A') {
      digitalWrite(4, HIGH);
    } else if (data == 'B') {
      digitalWrite(4, LOW);
    }
  }
}
```

**Sample Output:** LED turns on when `A` is received, off when `B` is received.

**Result:** Commands were received over a Zigbee link and used to control an LED successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
