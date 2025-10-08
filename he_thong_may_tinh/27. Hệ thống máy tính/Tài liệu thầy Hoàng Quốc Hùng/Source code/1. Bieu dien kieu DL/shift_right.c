#include <stdio.h>

#define B2b_t "%c%c%c%c %c%c%c%c"
#define B2b(byte)  \
  (byte & 0x80 ? '1' : '0'), \
  (byte & 0x40 ? '1' : '0'), \
  (byte & 0x20 ? '1' : '0'), \
  (byte & 0x10 ? '1' : '0'), \
  (byte & 0x08 ? '1' : '0'), \
  (byte & 0x04 ? '1' : '0'), \
  (byte & 0x02 ? '1' : '0'), \
  (byte & 0x01 ? '1' : '0') 
  
int main() {
	unsigned short a = 0xff01;
	short b = 0xff01;
	
	printf("a = "B2b_t"  "B2b_t"	", B2b(a>>8), B2b(a));
	printf("b = "B2b_t"  "B2b_t"  \n", B2b(b>>8), B2b(b));
	a = a >> 4;
	b = b >> 4;
	printf("Now Shift right 4 bits\n");
	printf("Logical shift\t\t\tArithmetic shift\n");
	printf("a = "B2b_t"  "B2b_t"	", B2b(a>>8), B2b(a));
	printf("b = "B2b_t"  "B2b_t"  \n", B2b(b>>8), B2b(b));
}