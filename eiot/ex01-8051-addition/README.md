# Ex 1 — 8051 addition (Keil)

**Aim:** Write an 8051 assembly program to add two 8-bit numbers and run it in the Keil simulator.

**Apparatus / Tools required:** Keil uVision (simulator mode), 8051/AT89C51 target.

**Algorithm**
1. Clear the carry flag.
2. Load the first operand into the accumulator.
3. Add the second operand to it.
4. Store the result in R0.

**Procedure**
1. New project, select AT89C51.
2. Add `addition.asm`, build (F7).
3. Debug (Ctrl+F5), step with F11, watch registers.

**Program**
```asm
        ORG 0000H
        CLR C
        MOV A, #20H
        ADD A, #21H
        MOV R0, A
        END
```

**Sample Output:** `A = 41H`, `R0 = 41H` (20H + 21H).

**Result:** Two 8-bit numbers were added successfully on the 8051 using assembly language.

## Notes
Record used `//` comments, which the assembler rejects; `;` is used instead.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
