# ex11-log-data-cloud

## Aim
Log data using the Raspberry Pi Pico and upload it to the cloud platform.

## Tools
Pico W, I2C LCD (SDA GP0, SCL GP1), Blynk, Thonny; libraries `pico_i2c_lcd`, `lcd_api`, `BlynkLib`.

## Procedure
Fill in Wi-Fi SSID, password and Blynk token in `log_data.py`, copy the libraries to the Pico, run.

## Expected output
LCD shows the on-chip temperature in C and F; V3 and V4 on the Blynk dashboard update every 10 s.

## Notes
Record had `machine.ADC(4)`, which is fixed to `ADC(4)` since `ADC` is already imported. Temperature formula: 27 - (V - 0.706) / 0.001721 (RP2040 datasheet).
