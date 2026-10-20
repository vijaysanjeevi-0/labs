# Ex 9.1 viva — Arduino master

1. **What is UART?** Asynchronous serial: start bit, data bits, stop bit, no shared clock line.
2. **Why must baud rates match on both ends?** Without a shared clock, the receiver samples by timing alone, set by the agreed baud rate.
3. **Why share GND between the two boards?** Both need a common 0 V reference for their signal voltages to be comparable.
4. **What is the logic-level issue here?** The UNO is 5 V logic and the Pico is 3.3 V; feeding 5 V into the Pico's RX can damage it.
5. **Why use `SoftwareSerial` here instead of the hardware UART?** To keep the hardware UART (pins 0/1) free for the USB serial monitor.
