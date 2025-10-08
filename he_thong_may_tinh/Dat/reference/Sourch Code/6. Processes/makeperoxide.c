/***********************************************************
* Making Hydro Peroxide H2O2 molecules
* 
***********************************************************/
 
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
  
#define up(sem) sem_post(sem)
#define down(sem) sem_wait(sem)
  
sem_t h_sem, o_sem, mutex;
int	molecules;
  
void* make_hydrogen(void *num);
void* make_oxygen(void *num);
void* make_peroxide(void *num);
  
int main()
{
    int i;
    pthread_t h_thread_id, o_thread_id, p_thread_id;
	
    sem_init(&h_sem,0,0);
	sem_init(&o_sem,0,0);
	sem_init(&mutex,0,1);
	
    pthread_create(&p_thread_id,NULL,make_peroxide,NULL);
	pthread_create(&h_thread_id,NULL,make_hydrogen,NULL);
	pthread_create(&o_thread_id,NULL,make_oxygen,NULL);
	
    pthread_join(o_thread_id,NULL);
	pthread_join(h_thread_id,NULL);
	pthread_join(p_thread_id,NULL);
}
  
void* make_hydrogen(void *num)
{
    while(1) {
		down(&mutex);
		up(&h_sem);
		printf("  H  ");
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

void* make_peroxide(void *num)
{
    while(1) {
		//... Viết đoạn mã ở đây
		sleep(1);
    }
}
