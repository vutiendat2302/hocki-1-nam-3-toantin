/* ----------------------------------------------------------------------------------------
	FIFO page replacement algorithm.
	Course: MAT3501 - Principles of Operating Systems, MIM - HUS
	Summary: Upon a page request, replace the first loaded page. See physicalMem_t in ramEmu.h
------------------------------------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

#ifndef RAMEMU_H
#include "ramEmu.h"
#endif

#ifndef FIFO_H
#include "fifo.h"
#endif

// initiate physical memory for FIFO algo
void fifo_memInit()
{
    physicalMem.current = 0;
}


// look up for a physical frame to be replaced by FIFO algo
int fifo_lookUp()
{	int p;

	// trả lại vị trí hiện tại trỏ bởi physicalMem.current;
	// dịch chuyển vị trí hiện tại tới phần tử tiếp theo
	p = physicalMem.current;
	physicalMem.current = (p+1)%NUMFRAMES;
	return p;
}

void fifo_updateFrameAttributes(int frameNo, int state)
{
	if (state) {	// !=0 set attributes
		physicalMem.used[frameNo] = 1; // mark the frame as occupied
	}
	else {			// ==0 clear attributes
		physicalMem.used[frameNo] = 0; // mark the frame as available
	}
}
