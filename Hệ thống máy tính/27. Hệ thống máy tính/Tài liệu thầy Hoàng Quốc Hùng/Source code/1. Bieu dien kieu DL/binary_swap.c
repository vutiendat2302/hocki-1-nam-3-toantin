#include <stdio.h>

#define B2b_t "%c%c%c%c%c%c%c%c"
#define B2b(byte)  \
  (byte & 0x80 ? '1' : '0'), \
  (byte & 0x40 ? '1' : '0'), \
  (byte & 0x20 ? '1' : '0'), \
  (byte & 0x10 ? '1' : '0'), \
  (byte & 0x08 ? '1' : '0'), \
  (byte & 0x04 ? '1' : '0'), \
  (byte & 0x02 ? '1' : '0'), \
  (byte & 0x01 ? '1' : '0') 

int main()
{	unsigned char a = 192, b=129;
	
	printf("a = "B2b_t", b = "B2b_t"\n", B2b(a), B2b(b));
	a = a ^ b;
	printf("a = "B2b_t", b = "B2b_t"\n", B2b(a), B2b(b));
	b = a ^ b;
	printf("a = "B2b_t", b = "B2b_t"\n", B2b(a), B2b(b));
	a = a ^ b;
	printf("a = "B2b_t", b = "B2b_t"\n", B2b(a), B2b(b));
}