#include <stdio.h>

int main()
{
	unsigned int a,b;
	
	a=0x8ffffff, b=0x7ffffff;
	if (a+b > a-b) printf("Bigger\n");
	else printf("Smaller\n");
	
	a=0x8fffffff, b=0x7fffffff;
	if (a+b > a-b) printf("Bigger\n");
	else printf("Smaller\n");
}