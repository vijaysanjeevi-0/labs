from machine import Pin
from time import sleep_ms, sleep

r = Pin(16, Pin.OUT)
y = Pin(17, Pin.OUT)
g = Pin(18, Pin.OUT)

while True:
    r.value(1)
    sleep_ms(1000)
    r.value(0)
    sleep_ms(1000)
    y.value(1)
    sleep(1)
    y.value(0)
    sleep(1)
    g.value(1)
    sleep(1)
    g.value(0)
    sleep(1)
