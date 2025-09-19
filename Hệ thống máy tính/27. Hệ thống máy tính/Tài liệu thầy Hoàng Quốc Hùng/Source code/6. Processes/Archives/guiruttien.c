// Gửi và rút tiền với race condition
// Biên dịch: gcc -o guiruttien guiruttien.c -pthread
#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define DELAY	sleep(rand() % 4)

int account; // tai khoan ngan hang

void *chaGuiTien() {    
	int y, i;
	for (i=0; i<5; i++) {
		y = account; DELAY;
		y = y+2; DELAY;
		account = y; DELAY;
		printf("Tao da gui. Account=%d\n", account);
	}
}

void *conRutTien() { 
	int x, i;
	for (i=0; i<5; i++) {
		x = account; DELAY;
		x = x - 3; DELAY;
		if (x>=0) { 
			account = x; 
			printf("Con da rut. Account=%d\n", account);
		}
		else { printf("Khong du tien\n");}
		DELAY;
		
	}
}

void main() {
   pthread_t tid1, tid2;
   
   printf("Account=%d\n",account);
   pthread_create(&tid1, NULL, chaGuiTien, NULL);   
   pthread_create(&tid2, NULL, conRutTien, NULL);   
   
   pthread_join(tid1, NULL);  
   pthread_join(tid2, NULL);  
}
