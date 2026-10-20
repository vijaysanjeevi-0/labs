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
