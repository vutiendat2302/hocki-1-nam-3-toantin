/***********************************************************
* Making Carbon Dioxide CO2 molecules
* 
***********************************************************/
 
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
  
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
  
sem_t c_sem, o_sem, mutex;
int	molecules;
  
void* make_carbon(void *num);
void* make_oxygen(void *num);
void* make_co2(void *num);
  
int main()
{
    int i;
    pthread_t c_thread_id, o_thread_id, co2_thread_id;
	
    sem_init(&c_sem,0,0);
	sem_init(&o_sem,0,0);
	sem_init(&mutex,0,1);
	
    pthread_create(&co2_thread_id,NULL,make_co2,NULL);
	pthread_create(&c_thread_id,NULL,make_carbon,NULL);
	pthread_create(&o_thread_id,NULL,make_oxygen,NULL);
	
    pthread_join(o_thread_id,NULL);
	pthread_join(c_thread_id,NULL);
	pthread_join(co2_thread_id,NULL);
}
  
void* make_carbon(void *num)
{
    while(1) {
		down(&mutex);
		up(&c_sem);
		printf("  C  ");
        up(&mutex);
        sleep(1);
    }
}

void* make_oxygen(void *num)
{
    while(1) {
        down(&mutex);
		up(&o_sem);
		printf("  O  ");
		up(&mutex);
		sleep(1);
    }
}

void* make_co2(void *num)
{
    while(1) {
		//... Viết đoạn mã ở đây
		sleep(1);
    }
}
