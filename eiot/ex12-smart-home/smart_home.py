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
