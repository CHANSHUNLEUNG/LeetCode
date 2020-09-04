package Questions.Searching.question257;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        doCombination(root.val + "->", root, result);
        return result;
    }

    private void doCombination(String prefix, TreeNode subRoot, List<String> result) {
        if (subRoot.left == null && subRoot.right == null) {
            result.add(prefix.substring(0, prefix.length() - 2));
            return;
        }
        if (subRoot.left != null) {
            String nextPrefix = prefix + subRoot.left.val + "->";
            doCombination(nextPrefix, subRoot.left, result);
        }
        if (subRoot.right != null) {
            String nextPrefix = prefix + subRoot.right.val + "->";
            doCombination(nextPrefix, subRoot.right, result);
        }
    }
}
