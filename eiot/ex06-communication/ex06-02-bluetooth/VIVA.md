# Ex 6.2 viva — Bluetooth communication

1. **Bluetooth range and band?** About 10 m (Class 2) in the 2.4 GHz ISM band.
2. **Why SoftwareSerial here?** The hardware UART (pins 0/1) is used by the USB monitor, so another serial port is emulated on pins 2 and 3.
3. **Default HC-05 baud rate?** 9600 in data mode (38400 in AT/command mode).
4. **How is the HC-05 paired?** Via the phone's Bluetooth settings using the module's default PIN (commonly 1234 or 0000).
5. **What happens if Tx/Rx are swapped?** No data is received in one or both directions, since Tx must connect to Rx and vice versa.
