# Ex 3 — ALU operations (8051)

**Aim:** Perform arithmetic and logical (ALU) operations on the 8051.

**Apparatus / Tools required:** Keil uVision (simulator).

**Algorithm**
1. Load the two operands for each operation into A (and B where needed).
2. Execute the operation (ADD, SUBB, MUL, DIV, ANL, ORL, XRL, CPL).
3. Store each result at its own memory address (41H-49H).

**Procedure:** build and debug `alu.asm`; inspect 41H-49H in the memory window.

**Program**
```asm
        ORG 0000H
        CLR C
; ADDITION
        MOV A, #20H
        ADD A, #21H
        MOV 41H, A
; SUBTRACTION
        MOV A, #20H
        SUBB A, #18H
        MOV 42H, A
; MULTIPLICATION
        MOV A, #03H
        MOV B, #04H
        MUL AB
        MOV 43H, A
; DIVISION
        MOV A, #95H
        MOV B, #10H
        DIV AB
        MOV 44H, A
        MOV 45H, B
; AND
        MOV A, #25H
        MOV B, #12H
        ANL A, B
        MOV 46H, A
; OR
        MOV A, #25H
        MOV B, #15H
        ORL A, B
        MOV 47H, A
; XOR
        MOV A, #45H
        MOV B, #67H
        XRL A, B
        MOV 48H, A
; NOT
        MOV A, #45H
        CPL A
        MOV 49H, A
        END
```

**Sample Output**

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

**Result:** Arithmetic and logical operations were performed on the 8051 successfully.

## Notes
Record wrote `MULAB`/`ANLA,B` (missing spaces) and `/` comments; fixed.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
