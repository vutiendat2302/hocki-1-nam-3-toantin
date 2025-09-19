package rvmidterm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode<Integer> current = queue.poll();

                if (i == level - 1) {
                    result.add(current.data);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}
