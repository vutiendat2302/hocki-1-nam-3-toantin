#include <stdio.h>

int main()
{
	printf("This CPU is %d-bit\n", (int)sizeof(void*)*8);
}