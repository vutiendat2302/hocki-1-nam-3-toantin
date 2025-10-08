//Philosopher with deadlocks

#include<stdio.h>    
#include <unistd.h>
#include <stdlib.h>
#include<pthread.h>
#include<semaphore.h>

#define N 5
#define TRUE 1
#define LEFT(i)	i
#define RIGHT(i) (i+1)%N
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
#define DELAY(R)	sleep(rand() % R);

sem_t chopstick[N]; // chopstic[i] represents for the ith philosopher's availability

void* philosopher(void *pNo) { // pNo points to a philosopher ID
	int i= *((int*)pNo);  // i is the ID number of the philosopher
	
	while (TRUE) {
		// Think
		printf("Philosopher %d is thinking...\n", i);
		DELAY(2);
		
		// Hungry
		printf("Philosopher %d is hungry...\n", i);
		
		// Take left chopstick
		down(&chopstick[LEFT(i)]);
		DELAY(2);
		// Take right chopstick
		down(&chopstick[RIGHT(i)]);
		
		// Eat
		printf("Philosopher %d is eating...\n", i);
		DELAY(2);
		
		// Drop left chopstick
		up(&chopstick[LEFT(i)]);
		// Drop right chopstick
		up(&chopstick[RIGHT(i)]);
	}
}


int main() {
	pthread_t tid[N];
	int philosopherID[N], i;

	// Initiate semaphores
	for (i=0; i<N; i++) sem_init(&chopstick[i],0,1);
	
	// Create philosopher threads
	for (i=0; i<N; i++) {
		philosopherID[i]=i;
		pthread_create(&tid[i],NULL,philosopher,&philosopherID[i]);
	}
	
	// Wait till all philosophers terminate
	for (i=0; i<N; i++) 
		pthread_join(tid[i],NULL);
}

