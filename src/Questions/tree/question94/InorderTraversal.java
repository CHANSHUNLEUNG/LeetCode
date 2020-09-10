package Questions.tree.question94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    //    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> answer = new ArrayList<>();
//        if (root == null) {
//            return answer;
//        }
//        dfsIn(root, answer);
//        return answer;
//    }
//
//    private void dfsIn(TreeNode root, List<Integer> answer) {
//        if (root == null) {
//            return;
//        }
//        dfsIn(root.left, answer);
//        answer.add(root.val);
//        dfsIn(root.right, answer);
//    }
//    no recusion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            answer.add(node.val);
            current = node.right;
        }
        return answer;
    }

    public static void main(String[] argv) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(null);
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
