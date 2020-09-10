package Questions.tree.question437;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return startWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int startWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = sum - root.val == 0 ? 1 : 0;
        return count + startWithRoot(root.left, sum - root.val) + startWithRoot(root.right, sum - root.val);
    }
}
