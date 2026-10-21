# Ex 2.2 — Block transfer

**Aim:** Copy a block of bytes from one memory area to another using indirect addressing.

**Apparatus / Tools required:** Keil uVision (simulator), AT89C51.

**Algorithm**
1. Point R0 at the source block and R1 at the destination block; load the byte count into R7.
2. Copy the byte at @R0 into A, then into @R1.
3. Increment R0 and R1.
4. Decrement R7 and repeat until it reaches zero.

**Procedure:** preload 30H-35H in the memory window, build `block_transfer.asm`, debug, watch 40H-45H.

**Program**
```asm
        ORG 0000H
        CLR C
        MOV R0, #30H
        MOV R1, #40H
        MOV R7, #06H
BACK:   MOV A, @R0
        MOV @R1, A
        INC R0
        INC R1
        DJNZ R7, BACK
        END
```

**Sample Output:** 40H-45H hold a copy of 30H-35H.

**Result:** A block of memory was copied using indirect addressing successfully.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions.
