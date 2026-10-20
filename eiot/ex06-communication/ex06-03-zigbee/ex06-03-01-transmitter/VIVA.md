# Ex 6.3.1 viva — Zigbee transmitter

1. **Zigbee standard?** IEEE 802.15.4 — low-power, low-rate wireless for sensors and mesh networks.
2. **Zigbee vs Bluetooth?** Zigbee favours mesh networking and very low power; Bluetooth favours simple point-to-point pairing with higher throughput.
3. **Why send both `A` and `B` repeatedly?** So the receiver can be started at any time and still see a toggle signal.
4. **What is the Zigbee module doing to the serial bytes?** Transmitting them transparently over the air to a paired module (transparent/AT mode).
5. **What happens with mismatched baud rates on Tx/Rx?** Bytes are received as garbage, since UART timing depends on a shared baud rate.
