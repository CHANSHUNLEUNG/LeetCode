package Questions.tree.question104;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        max = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return max;
    }
}
