/* 
Security vulnerability in getpeername
In 2002, programmers involved in the FreeBSD open source operating systems project realized that
their implementation of the getpeername library function had a security vulnerability. A simplified
version of their code went something like this:

Illustration of code vulnerability similar to that found in FreeBSD’s implementation of getpeername()
*/

/* Declaration of library function memcpy */
void *memcpy(void *dest, void *src, size_t n);

/* Kernel memory region holding user-accessible data */
#define KSIZE 1024
char kbuf[KSIZE];

/* Copy at most maxlen bytes from kernel region to user buffer */
int copy_from_kernel(void *user_dest, int maxlen) {
	/* Byte count len is minimum of buffer size and maxlen */
	int len = KSIZE < maxlen ? KSIZE : maxlen;
	memcpy(user_dest, kbuf, len);
	return len;
}