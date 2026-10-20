# General viva questions — Embedded Systems & IoT

Exercise-specific questions are in the `VIVA.md` inside each exercise folder.

## 8051 basics
1. **What is the 8051?** An 8-bit microcontroller with 4 KB ROM, 128 bytes RAM, 4 I/O ports, 2 timers and one UART on a single chip.
2. **Harvard vs Von Neumann?** The 8051 is Harvard architecture: separate program (code) and data memory spaces.
3. **What are SFRs?** Special Function Registers — memory-mapped control/status registers (e.g. P0–P3, TMOD, TCON) at fixed addresses.
4. **Assembler vs compiler?** An assembler translates assembly mnemonics 1:1 into machine code; a C compiler translates high-level C into machine code, often less directly.

## Embedded C
5. **Why `sbit`/`sfr` keywords?** Keil extensions that give named access to individual bits and registers of the target MCU.
6. **What is cross-compilation?** Compiling code on one machine (PC) to run on a different target architecture (8051/AVR/ARM).

## Arduino / MicroPython
7. **What is a sketch?** An Arduino program, written in C/C++, built around `setup()` and `loop()`.
8. **Why MicroPython on the Pico instead of C?** Faster to write and iterate, runs interactively via Thonny's REPL, at the cost of some speed and RAM.
9. **GPIO?** General Purpose Input/Output — a pin that can be configured as digital input or output.

## Communication & IoT
10. **UART vs I2C vs SPI?** UART is 2-wire point-to-point asynchronous serial; I2C is a 2-wire multi-device addressed bus; SPI is a faster 4-wire master/slave bus.
11. **What is Blynk?** A cloud IoT platform with virtual pins, a dashboard and a mobile app for monitoring/controlling devices.
12. **Edge vs cloud processing in IoT?** Edge processes data on the device itself (lower latency, less bandwidth); cloud centralises storage, analytics and remote access.
