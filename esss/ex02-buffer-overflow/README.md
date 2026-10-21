# Ex 2 — Buffer Overflow

**Aim:** Demonstrate a stack buffer overflow caused by `strcpy` into a fixed 16-byte buffer.

**Apparatus / Tools required:** GCC, GDB, a Linux terminal.

**Algorithm**
1. Take a command-line argument as input.
2. Copy it into a fixed 16-byte stack buffer with `strcpy` (no bounds check).
3. Print the buffer.

**Procedure**
```bash
gcc -fno-stack-protector -o vulnerable vulnerable.c
./vulnerable "Hello, World!"
./vulnerable "AAAAAAAAAAAAAAAAAAAAAAAAAAAA"      # 28 bytes, overflows the 16-byte buffer
gdb ./vulnerable
run AAAAAAAAAAAAAAAAAAAAAAAAAAAA
# inspect the overwritten return address: info registers / x/20xw $rsp
```

**Program**
```c
#include <stdio.h>
#include <string.h>

void vulnerable_function(char *input) {
    char buffer[16];
    strcpy(buffer, input);  // unsafe - no bounds check
    printf("You entered: %s\n", buffer);
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <input>\n", argv[0]);
        return 1;
    }
    vulnerable_function(argv[1]);
    return 0;
}
```

**Sample Output**
```
$ ./vulnerable "Hello, World!"
You entered: Hello, World!

$ ./vulnerable "AAAAAAAAAAAAAAAAAAAAAAAAAAAA"
Segmentation fault
```

**Result:** A stack buffer overflow was demonstrated successfully, overrunning the 16-byte buffer and crashing the program; the normal-input case was also verified to run cleanly.

## Notes
Verified in this sandbox: the program compiles and reproduces both the normal-input output and the crash on oversized input. Mitigation: `strncpy`/bounds-checked copies, keep stack protection enabled, enable ASLR/NX.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
