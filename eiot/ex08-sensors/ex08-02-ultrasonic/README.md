# Ex 8.2 — Ultrasonic sensor

**Tools:** Raspberry Pi Pico, HC-SR04, buzzer, resistor divider on Echo (5 V → 3.3 V).

**Connections:** Trigger → GP14, Echo → GP15 (via divider), buzzer → GP16.

**Run:** open `ultrasonic.py`, run.

**Expected output:** distance printed in cm every ~0.5 s; buzzer turns on when distance ≤ 10 cm.
