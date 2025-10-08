#include <stdio.h>

int main()
{
	float a = (3.14+1e20)-1e20;
	float b = 3.14+(1e20-1e20);
	printf("a = %f, b = %f\n", a, b);
}