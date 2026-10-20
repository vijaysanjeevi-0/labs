# ex02 viva — C compiler in the VM

1. **What does `gcc hello.c -o a.out` do?** Compiles and links `hello.c` into an executable named `a.out`.
2. **Compilation stages?** Preprocessing, compilation to assembly, assembly to object code, linking into an executable.
3. **What is `#include <stdio.h>` for?** Declares the standard I/O functions (like `printf`) used in the program.
4. **Why install a compiler in the VM instead of the host?** To build and test Linux binaries/environment-specific code in isolation from the host OS.
5. **What does `./a.out` do?** Runs the compiled executable from the current directory.
