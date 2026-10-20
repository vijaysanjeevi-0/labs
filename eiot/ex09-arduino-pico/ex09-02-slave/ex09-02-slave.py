from machine import Pin, UART

uart = UART(0, 9600)
led = Pin(16, Pin.OUT)

while True:
    if uart.any() > 0:
        data = uart.read()
        print(data)
        if b"A" in data:
            led.value(1)
            print("LED on \n")
            uart.write("LED on \n")
        elif b"B" in data:
            led.value(0)
            print("LED off \n")
            uart.write("LED off \n")
