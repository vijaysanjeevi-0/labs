# Ex 10 — Error detection code (CRC)

**Aim:** Implement the cyclic redundancy check in Java.

## Algorithm
**Sender**
1. Read the data bits and the divisor (generator polynomial, e.g. `x^2 + 1` = `101`).
2. Append (divisor length − 1) zeros to the data.
3. Divide it by the divisor using **modulo-2 division** (XOR instead of subtraction).
4. Replace the appended zeros with the remainder: this is the codeword T(x).
5. Transmit T.

**Receiver**
1. Divide the received bits T' by the same divisor (modulo-2).
2. Remainder 0 → no error. Non-zero → error, request retransmission.

## Run
```bash
javac Crc.java
java Crc
```
```
Enter data bits : 1011001
Enter divisor bits : 101
CRC code : 101100111
Enter received code : 101100111
No Error
```
Entering `101100101` as the received code (one bit flipped) prints `Error`.

## What was fixed
Bits are now typed as a single string (`1011001`) instead of one per line. Removed the stray `*/` that broke compilation. The check matches the manual's sample: data `1011001`, divisor `101`, code `101100111`.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
