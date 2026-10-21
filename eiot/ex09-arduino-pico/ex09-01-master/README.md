# Ex 9.1 — Arduino (master/sender)

**Aim:** Send commands from an Arduino UNO to a Raspberry Pi Pico over UART.

**Apparatus / Tools required:** Arduino IDE 2.0, Arduino UNO, jumper wires.

**Wiring:** UNO pin 3 (Tx) -> Pico UART0 RX; share GND. Use a level shifter/divider (UNO is 5V, Pico is 3.3V).

**Algorithm**
1. Open a SoftwareSerial port.
2. Send `A`, wait 1 s.
3. Send `B`, wait 1 s.
4. Repeat.

**Procedure:** open `ex09-01-master/ex09-01-master.ino`, upload.

**Program**
```cpp
#include <SoftwareSerial.h>

SoftwareSerial mySerial(2, 3);  // RX, TX

void setup() {
  mySerial.begin(9600);
}

void loop() {
  mySerial.write('A');
  delay(1000);
  mySerial.write('B');
  delay(1000);
}
```

**Sample Output:** sends `A` then `B`, 1 second apart, continuously.

**Result:** Commands were sent from the Arduino to the Pico over UART successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
