# Ex 10 — Error detection code (CRC)

**Aim:** Implement the cyclic redundancy check (CRC) in Java.

**Apparatus / Tools required:** JDK (`javac`, `java`).

**Algorithm — Sender**
1. Read the data bits and the divisor (generator polynomial, e.g. `x^2 + 1` = `101`).
2. Append (divisor length - 1) zeros to the data.
3. Divide it by the divisor using modulo-2 division (XOR instead of subtraction).
4. Replace the appended zeros with the remainder — this is the codeword T(x).
5. Transmit T.

**Algorithm — Receiver**
1. Divide the received bits T' by the same divisor (modulo-2).
2. Remainder 0 -> no error; non-zero -> error, request retransmission.

**Procedure**
```bash
javac Crc.java
java Crc
```

**Program**
```java
import java.util.*;

public class Crc {
    static String rem(String d, String g) {   // modulo-2 division: returns the last (g-1) bits
        char[] r = d.toCharArray();
        for (int i = 0; i <= r.length - g.length(); i++)
            if (r[i] == '1')
                for (int j = 0; j < g.length(); j++)
                    r[i + j] ^= g.charAt(j) - '0';
        return new String(r, r.length - g.length() + 1, g.length() - 1);
    }

    public static void main(String[] x) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data bits : ");
        String d = s.next();
        System.out.print("Enter divisor bits : ");
        String g = s.next();
        System.out.println("CRC code : " + d + rem(d + "0".repeat(g.length() - 1), g));
        System.out.print("Enter received code : ");
        System.out.println(rem(s.next(), g).contains("1") ? "Error" : "No Error");
    }
}
```

**Sample Output**
```
Enter data bits : 1011001
Enter divisor bits : 101
CRC code : 101100111
Enter received code : 101100111
No Error
```
Entering `101100101` as the received code (one bit flipped) prints `Error`.

**Result:** The CRC error-detection code was implemented in Java and verified to detect a corrupted codeword successfully.

## Notes
Bits are now typed as a single string (`1011001`) instead of one per line; a stray `*/` that broke compilation was removed.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
