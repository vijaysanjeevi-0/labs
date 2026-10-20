# Viva: ex03-alu-operations

**Q1. Where do MUL AB and DIV AB put results?**
MUL: low byte in A, high byte in B. DIV: quotient in A, remainder in B.

**Q2. Why CLR C before SUBB?**
SUBB subtracts the carry as a borrow, so it must be 0 for a plain subtraction.

**Q3. Which flags does ADD affect?**
CY, AC, OV and P.

**Q4. What does CPL A do?**
Complements every bit of A (one's complement).

**Q5. When is OV set after MUL?**
When the product exceeds 255 (B is non-zero).
