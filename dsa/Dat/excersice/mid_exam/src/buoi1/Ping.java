package buoi1;

import java.util.LinkedList;
import java.util.Queue;

public class Ping {
    /*Đề bài:
    * Thiết kế hẹ thông theo dõi số lượng cuộc gọi trong khoảng thời gian 3001 giây
    * tính cả thời ddieemer hiện tại. */
    /*Khi thực hiện ping: thêm giá trị t vào  queue, xóa khỏi queeu tất cả giá trị nhỏ hơn t - 3000
    * vì chúng ko trong khoảng t - 3000 tới t nữa*/
    private Queue<Integer> queue;
    public Ping() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int limit = 3000;
        while (!queue.isEmpty() && queue.peek() < t - limit) {
            queue.poll();
        }
        return queue.size();
    }
}
