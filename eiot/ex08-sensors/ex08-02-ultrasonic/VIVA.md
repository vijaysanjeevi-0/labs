# Ex 8.2 viva — Ultrasonic sensor

1. **How does HC-SR04 measure distance?** A 10 µs trigger pulse fires 8 bursts at 40 kHz; the Echo pin stays high for the round-trip time of the reflection.
2. **Why multiply by 0.0343 and divide by 2?** 0.0343 cm/µs is the speed of sound; dividing by 2 accounts for the round trip (out and back).
3. **Why a voltage divider on Echo?** The Pico's GPIO is 3.3 V and not 5 V tolerant, but the HC-SR04 Echo output is 5 V.
4. **What limits the sensor's range/accuracy?** Soft or angled surfaces absorb or deflect the pulse; typical range is about 2 cm–400 cm.
5. **What would happen without the `while echo.value()==0` wait?** The timing measurement would be wrong, since it must wait for the Echo pulse to actually start.
