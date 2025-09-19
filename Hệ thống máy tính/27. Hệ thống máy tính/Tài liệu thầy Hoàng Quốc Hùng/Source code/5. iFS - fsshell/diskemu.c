/* ----------------------------------------------------------------------------------------
	Disk emulation.
	Course: MAT3501 - Principles of Operating System, MIM - HUS
	Summary: Emulate a disk by using a file to store its disk blocks. One can access 
		a disk block through provided functions readBlock() and writeBlock().
------------------------------------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdint.h>
#include "diskemu.h"
char disk_name[128];
int disk_size;
int disk_fd;
int disk_blockCount;
int readBlock (int blockNum, void *buf)
{
    int offset, n;
    if (blockNum >= disk_blockCount)
        return (-1);
    offset = lseek(disk_fd, blockNum * BLOCKSIZE, SEEK_SET);
    if (offset == -1) return(-1);
    n = read(disk_fd, buf, BLOCKSIZE);
    if (n != BLOCKSIZE) return (-2);
    return (0);
}
int writeBlock (int blockNum, void *buf)
{
    int offset, n;
    if (blockNum >= disk_blockCount) return (-1);
    offset = lseek (disk_fd, blockNum * BLOCKSIZE, SEEK_SET);
    if (offset == -1) return(-1);
    n = write (disk_fd, buf, BLOCKSIZE);
    if (n != BLOCKSIZE) return (-2);
    return (0);
}
int createDisk(char *pDiskName, int power)
{ int numBlocks, ret, n, fd, i, diskSize;
 unsigned char buf[BLOCKSIZE];
 if ( (power<MINPOWER2SIZE)||(power>MAXPOWER2SIZE) ) return(-1);
 diskSize = 1 << power;
 numBlocks = diskSize / BLOCKSIZE;
 ret = open (pDiskName, O_CREAT |O_TRUNC | O_RDWR, 0666);
 if (ret == -1) return (-2);
 bzero ((void *)buf, BLOCKSIZE);
 fd = open (pDiskName, O_RDWR);
 for (i=0; i < numBlocks; ++i) {
  n = write (fd, buf, BLOCKSIZE);
  if (n != BLOCKSIZE) {
   return (-3);
  }
 }
 close (fd);
 return 0;
}
