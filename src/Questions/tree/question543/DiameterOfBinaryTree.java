package Questions.tree.question543;

public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        findDepth(root);
        return max;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = 1 + findDepth(root.left);
        int rightHeight = 1 + findDepth(root.right);
        max = Math.max(leftHeight + rightHeight, max);
        return Math.max(leftHeight, rightHeight);
    }
}
