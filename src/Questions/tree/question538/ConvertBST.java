package Questions.tree.question538;

public class ConvertBST {
    private int addValue = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        int temp = root.val;
        root.val += addValue;
        addValue += temp;
        dfs(root.left);
    }
}
