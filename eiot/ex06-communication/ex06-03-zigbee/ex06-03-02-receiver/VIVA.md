# Ex 6.3.2 viva — Zigbee receiver

1. **How does the receiver tell `A` apart from `B`?** It compares the byte read from `mySerial` against the character literals.
2. **Why check `mySerial.available() > 0` first?** `read()` returns -1 if no byte is ready; checking first avoids acting on invalid data.
3. **What is the risk of a shared antenna/channel?** Interference from other 2.4 GHz devices (Wi-Fi, Bluetooth) can corrupt or delay packets.
4. **How would you add a third command?** Compare for another character value and branch to another action.
5. **Why is GND shared between both Zigbee pairs?** Without a common ground, the signal (voltage) levels are not comparable between boards.
