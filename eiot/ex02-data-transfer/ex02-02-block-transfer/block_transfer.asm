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
