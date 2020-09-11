package Questions.tree.question530;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {
    private int diff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        dfsIn(root);
        return diff;
    }

    private void dfsIn(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsIn(root.left);
        if (this.preNode != null) {
            int currentDiff = Math.abs(root.val - preNode.val);
            this.diff = Math.min(diff, currentDiff);
        }
        preNode = root;
        dfsIn(root.right);
    }
}
