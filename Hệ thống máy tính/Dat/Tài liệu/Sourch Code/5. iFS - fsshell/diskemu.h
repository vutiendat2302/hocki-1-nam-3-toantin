#define DISKEMU_H

#define BLOCKSIZEBITS	8				
#define DISKNAME		"diskimage"		

#define BLOCKSIZE		(1<<BLOCKSIZEBITS)   	
#define MAXPOWER2SIZE	(2*BLOCKSIZEBITS-1) 	
#define MINPOWER2SIZE	(BLOCKSIZEBITS+3)		

int readBlock (int blockNum, void *buf);
int writeBlock (int blockNum, void *buf);
int createDisk(char *pDiskName, int diskSize);