//prehistoric cave tickets

#include<stdio.h>             
#include<pthread.h>
#include<semaphore.h>
#include <unistd.h>
#include <stdlib.h>

#define N 5		// Max tickets in the cave
#define MAXTHREADS 20
#define TRUE 1
#define FALSE 0
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)

sem_t tickets, mutex;
int noOfVisitors;

void* caveVisitor(void* id) {
	int i = *((int*) id);
	// Getting a ticket
	down(&tickets);
	
	// Entering the cave through a 1 man passage
	down(&mutex);
	printf("Visitor %d is entering the one-man passage\n",i);
	sleep(1);
	up(&mutex);
		
	// Contemplating
	printf("Visitor %d is is now in the cave and comtemplating...\n",i);
	sleep(2);
		
	// Getting out through the 1 man passage
	down(&mutex);
	printf("Visitor %d is going out through the one-man passage\n",i);
	sleep(1);
	up(&mutex);
	
	// Return the ticket and go home
	up(&tickets);
}

int main() {
	pthread_t tid[MAXTHREADS];
	int visitorID[MAXTHREADS];
	int i;

	sem_init(&mutex,0,1);
	sem_init(&tickets,0,N);
	
	for (i=0; i<MAXTHREADS; i++) {
		visitorID[i]=i+1;
		pthread_create(&tid[i],NULL,caveVisitor,&visitorID[i]);
		sleep(rand() % (5));
	}
	for (i=0; i<MAXTHREADS; i++) {
		pthread_join(tid[i],NULL);
	}
}

