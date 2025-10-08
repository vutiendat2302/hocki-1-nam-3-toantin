#include <stdio.h>

int fun1(unsigned int word) {
	return (int) ((word << 24) >> 24);
}
int fun2(unsigned int word) {
	return ((int) word << 24) >> 24;
}

int main() {
	unsigned int i = 0x000000C9;
	
	printf("fun1 returns %d, fun2 returns %d\n", fun1(i), fun2(i));
}