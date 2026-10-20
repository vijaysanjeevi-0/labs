# Viva: ex02-data-transfer

**Q1. Direct vs indirect addressing?**
Direct names the RAM address in the instruction (MOV 30H,A); indirect uses a register holding the address (MOV @R0,A).

**Q2. Which registers can be used for indirect addressing?**
R0 and R1 (and DPTR for external/code memory).

**Q3. What does DJNZ do?**
Decrements the operand and jumps if it is not zero; used for loop counters.

**Q4. Why can't MOV 30H,R0 be replaced by MOV R1,R0?**
8051 has no register-to-register MOV; data must go via A or a direct address.

**Q5. Size of internal RAM?**
128 bytes on 8051 (256 on 8052), with register banks at 00H-1FH.
