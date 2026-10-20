# Viva: ex01-8051-addition

**Q1. What does ADD A,#data do?**
Adds the immediate byte to the accumulator and leaves the result in A; flags CY, AC, OV, P are updated.

**Q2. Why CLR C?**
So a stale carry does not affect later carry-using instructions such as ADDC and SUBB.

**Q3. Which register is the accumulator?**
A (E0H), the destination of most arithmetic and logic instructions.

**Q4. What does ORG 0000H do?**
Sets the assembler location counter to the reset vector, where execution starts.

**Q5. What does END do?**
Tells the assembler that the source file has finished.
