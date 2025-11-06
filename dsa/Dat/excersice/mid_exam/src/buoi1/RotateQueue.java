package buoi1;

import java.util.LinkedList;
import java.util.Queue;

// De bai:
/*Nhap mot so nguyen duong n, va nhap mot day cac phan tu cua queue
mot phep bien doi dich chuyen phan tu dau tien ra sau phan tu cuoi cung cua day
tra ve day do sau khi bien doi k lan*/
public class RotateQueue {
    public Queue rotate(int[] a, int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            queue.offer(a[i]);
        }
        if (k == queue.size()) {
            return queue;
        } else if (k > queue.size()) {
            k = k - queue.size();
        }

        while(k>0)  {
            int temp = queue.poll();
            queue.offer(temp);
            k--;
        }

        return queue;
    }
}
