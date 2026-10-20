# ex01-8051-addition

## Aim
Write an 8051 assembly program to add two 8-bit numbers and run it in the Keil simulator.

## Tools
Keil uVision (simulator mode), 8051/AT89C51 target.

## Procedure
1. New project, select AT89C51.
2. Add `addition.asm`, build (F7).
3. Debug (Ctrl+F5), step with F11, watch registers.

## Expected output
`A = 41H`, `R0 = 41H` (20H + 21H).

## Notes
Record used `//` comments, which the assembler rejects; use `;`.
