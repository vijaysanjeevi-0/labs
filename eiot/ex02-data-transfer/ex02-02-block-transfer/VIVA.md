# Ex 2.2 viva — Block transfer

1. **Direct vs indirect addressing?** Direct names the RAM address in the instruction (`MOV 30H,A`); indirect uses a register holding the address (`MOV @R0,A`).
2. **Which registers allow indirect addressing?** R0 and R1 (and DPTR for external/code memory).
3. **What does DJNZ do?** Decrements the operand and jumps if it is not zero — used here as the loop counter.
4. **Why increment both R0 and R1 each pass?** One points at the source byte, the other at the destination; both must advance together.
5. **What happens if R7 starts at 0?** DJNZ decrements to 0FFH first, so the loop would run 256 times — always load the real count.
