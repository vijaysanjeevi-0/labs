# ex02 viva — Buffer Overflow

1. **What is a buffer overflow?** Writing more data into a fixed-size buffer than it can hold, overwriting adjacent memory.
2. **Why is `strcpy` dangerous here?** It copies until it hits a null terminator with no bounds check against the destination buffer's size.
3. **What is stack smashing?** A buffer overflow on the stack that overwrites the saved return address, letting an attacker redirect execution.
4. **What does `-fno-stack-protector` do, and why disable it for this demo?** Normally the compiler adds a canary value to detect stack corruption; it's disabled here so the overflow isn't blocked, for teaching purposes.
5. **Modern mitigations?** Stack canaries, ASLR (address space layout randomization), non-executable stack (NX/DEP), and bounds-checked functions like `strncpy`/`snprintf`.
