#include <REG51.H>

sbit LED = P2^0;

void main() {
    unsigned int j;
    while (1) {
        LED = 0;
        for (j = 0; j < 10000; j++);
        LED = 1;
        for (j = 0; j < 10000; j++);
    }
}
