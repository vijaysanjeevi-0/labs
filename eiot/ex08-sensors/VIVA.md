# Viva: ex08-sensors

**Q1. How does HC-SR04 measure distance?**
A 10 us trigger pulse sends 8 bursts at 40 kHz; echo pulse width is the round-trip time.

**Q2. Why divide by 2?**
The sound travels to the object and back.

**Q3. Why is IR output LOW on detection?**
Most modules pull the output low when reflected light is received.

**Q4. Speed of sound?**
About 343 m/s at 20 C.

**Q5. Why a voltage divider on echo?**
The Pico GPIO is 3.3 V and not 5 V tolerant.
