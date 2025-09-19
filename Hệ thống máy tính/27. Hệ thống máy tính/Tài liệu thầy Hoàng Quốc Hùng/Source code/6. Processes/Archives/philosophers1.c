// Dining philosophers using semaphore
 
#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include<semaphore.h>
#include<pthread.h>
  
#define N 5
#define THINKING 0
#define HUNGRY 1
#define EATING 2
#define LEFT(i) (i+N-1)%N
#define RIGHT(i) (i+1)%N
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
#define DELAY(R)	sleep(rand() % R);
  
sem_t mutex;
sem_t S[N];
  
void * philosopher(void *pNum);
void take_chopsticks(int);
void put_chopsticks(int);
void test(int);
void think(int);
void eat(int);
  
int state[N];
int phil_num[N];
  
int main()
{
    int i;
    pthread_t thread_id[N];
    sem_init(&mutex,0,1);
    for(i=0;i<N;i++)
        sem_init(&S[i],0,0);
    for(i=0;i<N;i++)
    {
		phil_num[i]=i;
        pthread_create(&thread_id[i],NULL,philosopher,&phil_num[i]);
    }
    for(i=0;i<N;i++)
        pthread_join(thread_id[i],NULL);
}
  
void *philosopher(void *pNum)
{
	int i=*(int*)pNum;
	while(1)
    {
        // think
		think(i);
		// take chopsticks
		take_chopsticks(i);
		// eat
		eat(i);
		// put chopsticks
		put_chopsticks(i);
    }
}
  
void take_chopsticks(int i)
{
    // change state to HUNGRY
	// check if 2 chopsticks are available
	// get the 2 chopsticks
	down(&mutex);
	state[i] = HUNGRY;
	test(i);
	up(&mutex);
	down(&S[i]);
	
    DELAY(3);
}
  
void test(int i)
{
    // check if 2 chopsticks are available and philosopher i is hungry
	//     then change state to EATING, set semaphore S[i] up
	if ( (state[i]==HUNGRY) &&
		 (state[LEFT(i)]!=EATING) &&
		 (state[RIGHT(i)]!=EATING) ) {
		state[i] = EATING;
		up(&S[i]);
	}
}
  
void put_chopsticks(int i)
{
    // change state back to THINKING
	// wake up the left philosopher
	// wake up the left philosopher
	down(&mutex);
	state[i] = THINKING;
	test(LEFT(i));
	test(RIGHT(i));
	up(&mutex);
}

void think(int i) {
	printf("Philosopher %d is thinking\n", i+1);
	DELAY(3);
}

void eat(int i) {
	printf("Philosopher %d is eating\n", i+1);
	DELAY(2);
}