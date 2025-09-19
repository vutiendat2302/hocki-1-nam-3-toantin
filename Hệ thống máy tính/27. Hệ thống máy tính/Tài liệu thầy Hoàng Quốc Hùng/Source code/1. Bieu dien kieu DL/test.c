#include <stdio.h>
#include <limits.h>

/*
float sum_elements(float a[], unsigned length) {
	int i;
	float result = 0;

	for (i = 0; i <= length-1; i++)
	result += a[i];
	return result;
}
*/

int main() {
	unsigned n=0x8000000F;
	int i,j=0;
	
	for (i=INT_MAX; i<n-1; i++) {
		j++;
		printf("i=%d ", i);
	}
	return 0;
}