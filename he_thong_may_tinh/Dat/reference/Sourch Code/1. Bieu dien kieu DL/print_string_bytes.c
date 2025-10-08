#include <stdio.h>
#include <string.h>

int main()
{	char pMyString[]="1234";
			
	for (int i=0; i<=strlen(pMyString); i++)
		printf("%x ", pMyString[i]);
	printf("\n");
}