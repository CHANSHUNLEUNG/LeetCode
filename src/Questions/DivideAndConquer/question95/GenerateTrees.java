package Questions.DivideAndConquer.question95;

import java.util.ArrayList;
import java.util.LinkedList;
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
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int min, int max) {
        List<TreeNode> result = new ArrayList<>();
        if (min > max) {
            result.add(null);
            return result;
        }
        for (int index = min; index <= max; index++) {
            List<TreeNode> leftSubtrees = generateSubtrees(min,index-1);
            List<TreeNode> rightSubtrees = generateSubtrees(index+1,max);
            for(TreeNode leftSubtree : leftSubtrees){
                for(TreeNode rightSubtree : rightSubtrees){
                    TreeNode root = new TreeNode(index,leftSubtree,rightSubtree);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
