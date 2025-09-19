//producer consumer using concurrent processes
// gcc -pthread -lrt

#include <stdio.h>             
#include <sys/mman.h>
#include <semaphore.h>
#include <sys/fcntl.h>
#include <assert.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

#define N 2
#define TRUE 1
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
#define DELAY(R) sleep(rand()% R)

void producer(void);
void consumer(void);
void produce_item(int* pItem);
void enter_item(int item);
void get_item(int* pItem);
void consume_item(int item);

// shared memory
struct mySharedMem {
	sem_t full,empty,mutex;
	int queue[N];
	int idx;
} *pMem;

int main() {
	pid_t pid,cid;
	int shmfd;
	int status;
		
	// Create unsized shared memory object;
	shm_unlink ("mySharedMemObject");	// remove the object, in case it exists
	shmfd = shm_open ("mySharedMemObject", O_CREAT | O_EXCL | O_RDWR, S_IRUSR | S_IWUSR);
	assert (shmfd != -1);
	
	// Resize the region to store 1 struct instance
	assert (ftruncate (shmfd, sizeof (struct mySharedMem)) != -1);
	
	// Map the object into memory so file operations aren't needed
	pMem = mmap (NULL, sizeof (struct mySharedMem),PROT_READ | PROT_WRITE, MAP_SHARED, shmfd, 0);
	assert (pMem != MAP_FAILED);
	
	// Initialize shared data
	sem_init(&(pMem->mutex),1,1);
	sem_init(&(pMem->empty),1,N);
	sem_init(&(pMem->full),1,0);
	pMem->idx = 0;
	
	// create a child process for the producer
	pid = fork();
	if (pid == 0) { // child process
		producer();
		munmap (pMem, sizeof (struct mySharedMem)); // unmap the object
		return 0;
	}
	else { // parent process
		cid = fork();   // create a child process for the customer
		if (cid == 0) { // child process
			consumer();
			munmap (pMem, sizeof (struct mySharedMem)); // unmap the object
			return 0;
		}
	}
	
	// parent process
	waitpid(pid, &status, 0);
	waitpid(cid, &status, 0);
	printf("Well done. Let's go home\n");
	munmap (pMem, sizeof (struct mySharedMem)); // unmap the object
	shm_unlink ("mySharedMemObject");	// remove the object
	return 0;
}

void producer() {
	int i, item;
	printf("P: Hello\n");
	for (i=0; i<10; i++) {
		produce_item(&item);
		down(&(pMem->empty));
		
		down(&(pMem->mutex));
		enter_item(item);
		up(&(pMem->mutex));
		up(&(pMem->full));
		
		DELAY(3);
    }
}

void consumer() {
	int i, item;
	printf("C: Hello\n");
	for (i=0; i<10; i++) {
		down(&(pMem->full));
		down(&(pMem->mutex));
		get_item(&item);
		up(&(pMem->mutex));
		up(&(pMem->empty));
		
		consume_item(item);
		DELAY(2);
	}
}

void produce_item(int* pItem) {
	(*pItem)=rand() % 100; // generate a random integer upto 99
	printf("P: Produce item %d\n", *pItem);
}

void enter_item(int item) {
	pMem->queue[pMem->idx]=item;
	pMem->idx++;
	printf("P: Enter item %d\n", item);
	if (pMem->idx>=N) printf("P: The queue is full\n");
}

void get_item(int* pItem) {
	pMem->idx--;
	(*pItem)=pMem->queue[pMem->idx];
	printf("C: Get item %d\n", *pItem);
	if (pMem->idx==0) printf("C: The queue is empty\n");
}

void consume_item(int item) {
	printf("C: Item %d is yum yum!\n", item);
}