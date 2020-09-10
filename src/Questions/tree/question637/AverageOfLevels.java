package Questions.tree.question637;

import Questions.LinkedList.question328.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int iterationSize = queue.size();
            double subTotal = 0;
            for (int index = 0; index < iterationSize; index++) {
                TreeNode current = queue.poll();
                subTotal += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ret.add(subTotal / iterationSize);
        }
        return ret;
    }
}
