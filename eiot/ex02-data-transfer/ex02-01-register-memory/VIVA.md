# Ex 2.1 viva — Register to memory transfer

1. **Can you MOV directly between two registers?** No — the 8051 has no register-to-register MOV; data must go via the accumulator or a direct address.
2. **What does MOV 30H,A do?** Copies the accumulator into internal RAM address 30H (direct addressing).
3. **Which registers hold R0–R7?** The active register bank, selected by the PSW bank-select bits (RS1, RS0).
4. **Why CLR C at the start?** So a stale carry does not affect any later carry-using instruction.
5. **Size of internal RAM on 8051?** 128 bytes (00H–7FH); 256 on the 8052.
