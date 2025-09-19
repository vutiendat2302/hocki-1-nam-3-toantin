#include <stdio.h>

float sum_elements(float a[], unsigned length) {
	int i;
	float result = 0;

	
	for (i = 0; i <= length-1; i++) 
			result += a[i];
	return result;
}
void main(void) {
	float a[]={1,2,3};
	printf("Result = %f\n", sum_elements(a, 0));
}