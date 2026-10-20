from machine import Pin
from time import sleep

led = Pin(16, Pin.OUT)
sw = Pin(15, Pin.IN)

while True:
    bt = sw.value()
    if bt == True:
        print("LED ON")
        led.value(1)
        sleep(2)
        led.value(0)
        sleep(2)
        led.value(1)
        sleep(2)
        led.value(0)
        sleep(2)
    else:
        print("LED OFF")
        sleep(0.5)
