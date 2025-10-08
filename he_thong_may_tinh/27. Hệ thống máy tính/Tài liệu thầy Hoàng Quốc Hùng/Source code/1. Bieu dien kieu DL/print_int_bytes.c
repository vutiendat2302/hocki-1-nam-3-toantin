#include <stdio.h>

int main()
{	unsigned int a = 0xffeeddcc;
	unsigned char *b = (char*)&a;
	long unsigned c;
	
	printf("a = %x %x %x %x\n", *(b+3), *(b+2), *(b+1), *b);
	printf("is stored at address %p\n", &a);
	
	// Hoặc in giá trị của con trỏ b theo từng byte một
	c = (long unsigned) b;
	b = (unsigned char*) &c;
	printf("b = %x%x%x%x %x%x%x%x\n", 
		*(b+7), *(b+6), *(b+5), *(b+4),
		*(b+3), *(b+2), *(b+1), *b);
}