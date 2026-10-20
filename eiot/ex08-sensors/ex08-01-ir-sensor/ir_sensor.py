from machine import Pin
from time import sleep

buzzer = Pin(16, Pin.OUT)
ir = Pin(15, Pin.IN)

while True:
    ir_value = ir.value()
    if ir_value == True:
        print("Buzzer OFF")
        buzzer.value(0)
    else:
        print("Buzzer ON")
        buzzer.value(1)
    sleep(0.5)
