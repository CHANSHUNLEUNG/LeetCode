package Questions.tree.question513;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            int iterationSize = queue.size();
            boolean first = true;
            for (int index = 0; index < iterationSize; index++) {
                TreeNode current = queue.poll();
                if(first){
                    first = false;
                    ret = current.val;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return ret;
    }
}
