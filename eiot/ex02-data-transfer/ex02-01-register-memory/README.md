# Ex 2.1 — Register to memory transfer

**Aim:** Move data from registers to internal RAM via the accumulator.

**Apparatus / Tools required:** Keil uVision (simulator), AT89C51.

**Algorithm**
1. Load a value into R0 and another into R1.
2. Move R0 to A, then store A into RAM address 30H.
3. Move R1 to A, then store A into RAM address 31H.

**Procedure:** build `transfer.asm`, debug (Ctrl+F5), watch internal RAM 30H/31H.

**Program**
```asm
        ORG 0000H
        CLR C
        MOV R0, #55H
        MOV R1, #6FH
        MOV A, R0
        MOV 30H, A
        MOV A, R1
        MOV 31H, A
        END
```

**Sample Output:** `30H = 55H`, `31H = 6FH`.

**Result:** Data was transferred from registers to internal memory via the accumulator successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
