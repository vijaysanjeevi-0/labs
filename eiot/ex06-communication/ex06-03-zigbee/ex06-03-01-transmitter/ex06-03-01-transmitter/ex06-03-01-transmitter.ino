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
