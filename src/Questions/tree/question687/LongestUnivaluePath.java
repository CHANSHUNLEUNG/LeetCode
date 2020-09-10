package Questions.tree.question687;

public class LongestUnivaluePath {
//    public int longestUnivaluePath(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(startWithRoot(root, root.val),
//                Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
//    }
//
//    private int startWithRoot(TreeNode root, int val) {
//        return startWithleaf(root.left, val) + startWithleaf(root.right, val);
//    }
//
//    private int startWithleaf(TreeNode root, int val) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.val != val) {
//            return 0;
//        }
//
//        return 1 + Math.max(startWithleaf(root.left, val), startWithleaf(root.right, val));
//    }

    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftMax = root.left != null && root.val == root.left.val ? left + 1 : 0;
        int rightMax = root.right != null && root.val == root.right.val ? right + 1 : 0;
        maxLength = Math.max(maxLength, leftMax + rightMax);
        return Math.max(leftMax, rightMax);
    }
}
