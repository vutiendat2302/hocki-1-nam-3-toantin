#include <stdio.h>

int main()
{	unsigned int a = 0xffeeddcc;
	unsigned char *b = (char*)&a;
	long unsigned c;
	
	printf("a = %x %x %x %x\n", *(b+3), *(b+2), *(b+1), *b);
        printf("is stored at address %p\n", b);

	printf("\nAddress\t\tValue\n");
	printf("-------\t\t-----\n");
	for (int i=0; i<4; i++) {
		printf("%p\t", b+i);
		printf("%x\n", *(b+i));
	}
}
