# Ex 5.2 — Arduino programming: LED blink

**Aim:** Write and run a first Arduino sketch.

**Apparatus / Tools required:** Arduino IDE 2.0, Arduino UNO, USB cable.

**Algorithm**
1. Configure the LED pin as output in `setup()`.
2. In `loop()`: set it HIGH, delay 1 s, set it LOW, delay 1 s.

**Procedure:** open `ex05-02-led-blink/ex05-02-led-blink.ino`, select board + port, Upload.

**Program**
```cpp
const int ledPin = 13;

void setup() {
  pinMode(ledPin, OUTPUT);
}

void loop() {
  digitalWrite(ledPin, HIGH);
  delay(1000);
  digitalWrite(ledPin, LOW);
  delay(1000);
}
```

**Sample Output:** the on-board LED (pin 13) blinks, 1 s on / 1 s off.

**Result:** A first Arduino sketch was written and run successfully, blinking the on-board LED.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
