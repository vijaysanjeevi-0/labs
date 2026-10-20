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
