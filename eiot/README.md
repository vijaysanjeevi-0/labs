# Embedded Systems and IoT Lab

Code for each experiment in the record, in the language the record uses.

| Exp | Folder | Language / tool |
|---|---|---|
| 1 | `ex01-8051-addition` | 8051 assembly, Keil |
| 2 | `ex02-data-transfer/` type1, type2 | 8051 assembly, Keil |
| 3 | `ex03-alu-operations` | 8051 assembly, Keil |
| 4A, 4B | `ex04-embedded-c/` | Embedded C, Keil |
| 5A, 5B | `ex05-arduino/` | Arduino C++ |
| 6A, 6B, 6C | `ex06-communication/` | Arduino C++ |
| 7A, 7B | `ex07-raspberry-pi/` | MicroPython (Pico) |
| 8 | `ex08-sensors` | MicroPython |
| 9 | `ex09-arduino-pico/` master, slave | Arduino C++ + MicroPython |
| 10 | `ex10-cloud-platform-blynk` | Blynk setup |
| 11 | `ex11-log-data-cloud` | MicroPython |
| 12 | `ex12-smart-home` | MicroPython |

Each experiment folder has `README.md` and `VIVA.md`. Arduino sketches sit in a folder named after the sketch, as the IDE requires.

Checks done: Python files compile, Arduino sketches pass a C++ syntax check against stub headers. The 8051 assembly and Keil C were not run in a simulator here; expected values in the READMEs were worked out by hand.
