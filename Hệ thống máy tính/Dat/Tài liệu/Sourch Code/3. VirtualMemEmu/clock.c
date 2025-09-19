/* ----------------------------------------------------------------------------------------
	CLOCK page replacement algorithm.
	Course: MAT3501 - Principles of Operating Systems, MIM - HUS
	Summary: f page i is used, set its attribute R=1. Upon a page request, erase attribute R 
		and move on for a page with R=0. See physicalMem_t in ramEmu.h
------------------------------------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

#ifndef RAMEMU_H
#include "ramEmu.h"
#endif

#ifndef CLOCK_H
#include "clock.h"
#endif

// initiate physical memory for CLOCK algo
void clock_memInit()
{
    // write your code here
	physicalMem.current = 0;
	for(int i=0; i < NUMFRAMES; i++)
        physicalMem.clock[i] = -1;
}


/* look up for a physical frame to be replaced by CLOCK algo
Instruction: frame i has a label clock[i]
	step 1 - search for a page frame with zero label, during the search erase all labels on the way
	step 2 - remember the frame position found
	step 3 - move the clock handle to the next position
	step 4 - return the found position
*/
int clock_lookUp()
{	int p;
	
	// write your code here
	
	// Lặp từ vị trí physicalMem.current tìm 1 trang có nhãn physicalMem.clock[] == 0
		// Nếu gặp trang có nhãn là 1 thì:
		// Xóa physicalMem.clock[] trong quá trình duyệt
		// Chuyển tới trang tiếp theo
	// Đặt vị trí hiện tại physicalMem.current trỏ tới trang tiếp theo
	// Trả lại vị trí tìm thấy
	p = physicalMem.current;
	while (physicalMem.clock[p]!=0) {
		physicalMem.clock[p] = 0;  // xoa bit R
		p = (p+1) % NUMFRAMES;
	}
	physicalMem.current = (p+1)% NUMFRAMES;
	return p;
}

void clock_updateFrameAttributes(int frameNo, int state)
{
	if (state) {	// !=0 set attributes
		physicalMem.clock[frameNo] = 1; // mark the page has been referred to (set bit R = 1)
	}
	else {			// ==0 clear attributes
		physicalMem.clock[frameNo] = 0; // erase the Referred bit
	}
}

