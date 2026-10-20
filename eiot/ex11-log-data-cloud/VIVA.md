# Viva: ex11-log-data-cloud

**Q1. Which sensor is ADC(4)?**
The RP2040's internal temperature sensor.

**Q2. Why * 3.3 / 65536?**
read_u16 returns 0-65535 for 0-3.3 V.

**Q3. What does virtual_write do?**
Sends a value to a Blynk virtual pin.

**Q4. Why blynk.run() in the loop?**
It processes network events and keeps the connection alive.

**Q5. What is I2C?**
Two-wire bus (SDA, SCL) with addressed devices.
