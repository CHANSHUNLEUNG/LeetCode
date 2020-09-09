package Questions.tree.question110;

public class IsBalanced {
    private boolean answer = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        findHeight(root);
        return answer;
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 1 + findHeight(root.left);
        int rightHeight = 1 + findHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            answer = false;
        }
        return Math.max(leftHeight, rightHeight);
    }

}
