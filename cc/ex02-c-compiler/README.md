# Ex 2 — C compiler in the VM

**Aim:** To install a C compiler in the virtual machine and execute a sample C program.

**Apparatus / Tools required:** A Linux VM (from ex01), GCC, a text editor.

**Algorithm**
1. Write a C source file with a `main` function that prints a message.
2. Compile it with `gcc` to produce an executable.
3. Run the executable.

**Procedure**
```bash
gcc helloworld.c -o a.out
./a.out
```

**Program**
```c
#include <stdio.h>

int main(void) {
    printf("Hello World\n");
    return 0;
}
```

**Sample Output**
```
Hello World
```

**Result:** The C compiler was installed in the virtual machine and the sample program was compiled and executed successfully.
