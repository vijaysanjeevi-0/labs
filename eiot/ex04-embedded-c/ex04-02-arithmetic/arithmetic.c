#include <REG51.H>

void main() {
    unsigned char a = 0x10, b = 0x04;
    P0 = a - b;
    P1 = a + b;
    P2 = a * b;
    P3 = a / b;
    while (1);
}
