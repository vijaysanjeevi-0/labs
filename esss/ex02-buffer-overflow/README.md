# ex02 - Buffer Overflow

## Aim
Demonstrate a stack buffer overflow caused by `strcpy` into a fixed 16-byte buffer.

## Build
```
gcc -fno-stack-protector -o vulnerable vulnerable.c
```

## Run
```
./vulnerable "Hello, World!"
```
```
You entered: Hello, World!
```

```
./vulnerable "AAAAAAAAAAAAAAAAAAAAAAAAAAAA"
```
Segmentation fault — the 28-byte input overruns the 16-byte buffer and corrupts the saved return address.

## Analyse
```
gdb ./vulnerable
run AAAAAAAAAAAAAAAAAAAAAAAAAAAA
```
Inspect the overwritten return address with `info registers` / `x/20xw $rsp`.

## Mitigation
Use `strncpy`/bounds-checked copies, keep stack protection enabled, enable ASLR/NX.
