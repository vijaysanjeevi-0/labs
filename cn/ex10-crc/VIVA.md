# Ex 10 viva — CRC

1. **What is CRC?** Cyclic Redundancy Check: a checksum computed by polynomial (modulo-2) division to detect transmission errors.
2. **Detection or correction?** Detection only; the receiver asks for retransmission.
3. **What is the generator polynomial?** The agreed divisor, e.g. `x^2 + 1` = `101`, `x^3 + x + 1` = `1011`.
4. **What is modulo-2 division?** Binary division using XOR instead of subtraction (no borrows).
5. **How many bits are appended?** One less than the divisor length (the degree of the generator).
6. **Sender steps?** Append zeros, divide by the generator, replace the zeros with the remainder, transmit.
7. **Receiver check?** Divide the received bits by the generator; remainder 0 means no error detected.
8. **Worked example?** Data 1011001, divisor 101: remainder 11, codeword 101100111.
9. **Which errors are detected?** All single-bit errors, all burst errors no longer than the number of CRC bits, and most longer bursts.
10. **Can CRC miss an error?** Yes, if the error pattern is itself divisible by the generator.
11. **CRC vs parity vs checksum?** Parity is 1 bit and weak. Checksum is a simple sum (used in IP/TCP). CRC is stronger and is used in Ethernet (CRC-32).
12. **What is Hamming distance?** Number of bit positions in which two codewords differ; it determines how many errors a code can detect/correct.
13. **How to correct errors?** Use error-correcting codes such as Hamming code, or retransmit (ARQ).
14. **Why must the generator start and end with 1?** The leading 1 fixes its degree (so the right number of check bits is added). The trailing 1 (non-zero constant term) guarantees a single-bit error `x^i` is never divisible by the generator, so every single-bit error is detected.
