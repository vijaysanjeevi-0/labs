# ex03-alu-operations

## Aim
Perform arithmetic and logical (ALU) operations on the 8051.

## Tools
Keil uVision (simulator).

## Procedure
Build and debug `alu.asm`; inspect 41H-49H in the memory window.

## Expected output
| Addr | Value | Operation |
|---|---|---|
| 41H | 41H | 20H + 21H |
| 42H | 08H | 20H - 18H |
| 43H | 0CH | 03H * 04H |
| 44H / 45H | 09H / 05H | 95H / 10H (quotient / remainder) |
| 46H | 00H | 25H AND 12H |
| 47H | 35H | 25H OR 15H |
| 48H | 22H | 45H XOR 67H |
| 49H | BAH | NOT 45H |

## Notes
Record wrote `MULAB`/`ANLA,B` (missing spaces) and `/` comments; fixed.
