package Questions.tree.question230;

public class KthSmallest {
    private int count = 0;
    private int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfsInorder(root, k);
        return answer;
    }

    private TreeNode dfsInorder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfsInorder(root.left, k);
        count++;
        if (count == k) {
            answer = root.val;
        }
        TreeNode right = dfsInorder(root.right, k);
        return root;
    }
}
