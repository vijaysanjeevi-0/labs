# Ex 11 — Log data using the Pico and upload to the cloud

**Aim:** Log the Pico's on-chip temperature on an I2C LCD and upload it to Blynk.

**Apparatus / Tools required:** Pico W, I2C LCD (SDA GP0, SCL GP1), Blynk, Thonny; libraries `pico_i2c_lcd`, `lcd_api`, `BlynkLib`.

**Algorithm**
1. Read the on-chip temperature sensor (ADC channel 4) and convert it to Celsius/Fahrenheit.
2. Display both values on the I2C LCD.
3. Connect to Wi-Fi, then to Blynk.
4. Send both values to Blynk virtual pins V3 and V4 every ~10 s.

**Procedure:** fill in Wi-Fi SSID, password and Blynk token in `log_data.py`, copy the libraries to the Pico, run.

**Program**
```python
from machine import Pin, I2C, ADC
from pico_i2c_lcd import I2cLcd
import time
import network
import BlynkLib

adc = ADC(4)  # on-chip temperature sensor
i2c = I2C(0, sda=Pin(0), scl=Pin(1), freq=400000)
I2C_ADDR = i2c.scan()[0]
lcd = I2cLcd(i2c, I2C_ADDR, 2, 16)

wlan = network.WLAN()
wlan.active(True)
wlan.connect("Wifi_Username", "Wifi_Password")
BLYNK_AUTH = "Your_Token"

# connect the network
wait = 10
while wait > 0:
    if wlan.status() < 0 or wlan.status() >= 3:
        break
    wait -= 1
    print("waiting for connection...")
    time.sleep(1)

# handle connection error
if wlan.status() != 3:
    raise RuntimeError("network connection failed")
else:
    print("connected")
    ip = wlan.ifconfig()[0]
    print("IP: ", ip)

# connect to Blynk
blynk = BlynkLib.Blynk(BLYNK_AUTH)
lcd.clear()

while True:
    ADC_voltage = adc.read_u16() * (3.3 / 65536)
    temperature_celcius = 27 - (ADC_voltage - 0.706) / 0.001721
    temp_fahrenheit = 32 + (1.8 * temperature_celcius)
    print("Temperature in C: {}".format(temperature_celcius))
    print("Temperature in F: {}".format(temp_fahrenheit))
    lcd.move_to(0, 0)
    lcd.putstr("Temp:")
    lcd.putstr(str(round(temperature_celcius, 2)))
    lcd.putstr("C ")
    lcd.move_to(0, 1)
    lcd.putstr("Temp:")
    lcd.putstr(str(round(temp_fahrenheit, 2)))
    lcd.putstr("F")
    time.sleep(5)
    blynk.virtual_write(3, temperature_celcius)
    blynk.virtual_write(4, temp_fahrenheit)
    blynk.log_event(temperature_celcius)
    blynk.run()
    time.sleep(5)
```

**Sample Output:** LCD shows the on-chip temperature in C and F; V3 and V4 on the Blynk dashboard update every ~10 s.

**Result:** The Pico's temperature was logged on an LCD and uploaded to the Blynk cloud platform successfully.

## Notes
Record had `machine.ADC(4)`, fixed to `ADC(4)` since `ADC` is already imported.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
