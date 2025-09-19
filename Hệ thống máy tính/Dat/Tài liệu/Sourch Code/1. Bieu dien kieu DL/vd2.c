#include <stdio.h>

int main()
{
	float a = 0.1;	
	if (a+a == 0.2) printf("Yes\n"); 
	else printf("No\n");
	printf("because a = %.8f (8-digit precision)\n", a);
	printf("because a = %.32f (32-digit precision)\n", a);
}
