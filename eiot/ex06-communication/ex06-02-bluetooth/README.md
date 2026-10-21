# Ex 6.2 — Bluetooth communication

**Aim:** Control an LED over Bluetooth using an HC-05 module.

**Apparatus / Tools required:** Arduino IDE 2.0, Arduino UNO, HC-05 Bluetooth module, jumper wires, a Bluetooth terminal app.

**Connections**

| Arduino UNO pin | HC-05 |
|---|---|
| 5V | VCC |
| GND | GND |
| 2 | Tx |
| 3 | Rx |

LED on pin 4.

**Algorithm**
1. Open a SoftwareSerial port to the HC-05.
2. If a byte is available, read it.
3. If it is `1`, turn the LED on; if `2`, turn it off.

**Procedure:** open `ex06-02-bluetooth/ex06-02-bluetooth.ino`, upload, pair the phone with the HC-05, open a Bluetooth terminal app, send `1` or `2`.

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
    if (data == '1') {
      digitalWrite(4, HIGH);
      Serial.println("LED ON");
    } else if (data == '2') {
      digitalWrite(4, LOW);
      Serial.println("LED OFF");
    }
  }
}
```

**Sample Output:** LED turns on for `1`, off for `2`.

**Result:** An LED was controlled over Bluetooth using an HC-05 module successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
