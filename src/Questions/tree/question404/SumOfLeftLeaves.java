package Questions.tree.question404;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
