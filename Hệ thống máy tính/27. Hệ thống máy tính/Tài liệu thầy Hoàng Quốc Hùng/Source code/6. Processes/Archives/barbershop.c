#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#include <pthread.h>
#include <semaphore.h>

#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
#define DELAY(R) sleep(rand() % R)
#define MAX_CLIENTS 25


// Function prototypes...
void *client(void *num);
void *barber(void *);

void randwait(int secs);

sem_t clients;
sem_t barbers;
sem_t mutex, seatBelt;
int waiting, numChairs, numClients;
int allDone = 0;

int main(int argc, char *argv[]) {
    pthread_t btid;
    pthread_t tid[MAX_CLIENTS];
    int i;
    int clientID[MAX_CLIENTS];
    
        
    // Check to make sure there are the right number of command line arguments.
    if (argc != 3) {
		printf("Usage: %s <Num clients> <Num Chairs>\n",argv[0]);
		exit(-1);
    }
    
    // Get the command line arguments and convert them into integers.
    numClients = atoi(argv[1]);
    numChairs = atoi(argv[2]);
        
    // Make sure the number of threads is less than the number of clients we can support.
    if (numClients > MAX_CLIENTS) {
		printf("The maximum number of clients is %d.\n", MAX_CLIENTS);
		exit(-1);
    }
    
    // Initialize the numbers array.
    for (i=0; i<MAX_CLIENTS; i++) clientID[i] = i;
		
    // Initialize the semaphores with initial values...
    sem_init(&clients, 0, 0);
    sem_init(&barbers, 0, 0);
    sem_init(&mutex, 0, 1);
	sem_init(&hatOff, 0, 0);
    sem_init(&seatBelt, 0, 0);
    
    // Create the barber.
    pthread_create(&btid, NULL, barber, NULL);

    // Create the clients.
    for (i=0; i<numClients; i++) 
		pthread_create(&tid[i], NULL, client, (void *)&clientID[i]);

    // Join each of the threads to wait for them to finish.
    for (i=0; i<numClients; i++) 
		pthread_join(tid[i],NULL); 

    // When all of the clients are finished, kill the barber thread.
    allDone = 1; 
    up(&clients);  // Wake the barber so he will exit.
	pthread_join(btid,NULL); 
}

void *client(void *number) {
    int num = *(int *)number;

	DELAY(10);
    printf("client %d arrives\n", num);

    // Check out availability
	down(&mutex);
	if (waiting < numChairs) {
		waiting++;
		up(&clients);
		printf("Client %d is waiting for turn\n", num); 
		up(&mutex);
		
		down(&barbers);
		
		// get hair cut for a while
		printf("Client %d is having a haircut\n", num);
		down(&seatBelt);		
		printf("Client %d is going home\n", num);
	}
	else {
		printf("Shop full. Client %d leaves\n", num);
		up(&mutex);
	}
}

void *barber(void *junk) {
    while (!allDone) {

		// Sleep until someone arrives and wakes you..
		printf("The barber is sleeping\n");
		down(&clients);

		// Skip this stuff at the end...
		if (!allDone) {

			down(&mutex);
			waiting--;
			up(&barbers);
			up(&mutex);
			
			// Take a random amount of time to cut the client's hair.
			printf("The barber is cutting hair\n");
			
			sleep(2); // it takes a while
			printf("The barber has finished cutting hair.\n");
			up(&seatBelt);
		}
		else {
			printf("The barber is going home for the day.\n");
		}
    }
}
