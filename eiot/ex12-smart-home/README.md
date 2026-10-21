# Ex 12 — IoT-based smart home system

**Aim:** Design a smart home automation system: turn an LED on/off from the cloud.

**Apparatus / Tools required:** Pico W, LED on GP16, Wi-Fi, Blynk.

**Algorithm**
1. Connect to Wi-Fi, then to Blynk.
2. Register a handler for virtual pin V0.
3. When V0 changes, set the LED to match (1 -> on, else off).
4. Keep processing Blynk events in a loop.

**Procedure:** set credentials and token in `smart_home.py`, run it, then toggle a switch widget on virtual pin V0.

**Program**
```python
import time
import network
import BlynkLib
from machine import Pin

led = Pin(16, Pin.OUT)

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


# register virtual pin handler
@blynk.on("V0")
def v0_write_handler(value):
    if int(value[0]) == 1:
        led.value(1)  # turn the led on
    else:
        led.value(0)  # turn the led off


while True:
    blynk.run()
```

**Sample Output:** LED turns on and off from the Blynk dashboard switch.

**Result:** A simple IoT smart-home system was designed and the LED was controlled from the cloud successfully.

## Notes
The record wrote the handler as `@blynk.on("VO")` (letter O); the virtual pin is `V0`.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
