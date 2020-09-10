package Questions.tree.question337;

public class Rob {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentVal = root.val;
        int leftIndirect = (root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right);
        int rightIndirect = (root.right == null) ? 0 : rob(root.right.right) + rob(root.right.left);
        int direct = rob(root.left) + rob(root.right);
        int indirect = root.val + leftIndirect + rightIndirect;
        return Math.max(direct,indirect);
    }
}
