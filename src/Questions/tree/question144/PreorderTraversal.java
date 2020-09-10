package Questions.tree.question144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> answer = new ArrayList<>();
//        dfsPre(root, answer);
//        return answer;
//    }
//
//    private void dfsPre(TreeNode root, List<Integer> answer) {
//        if (root == null) {
//            return;
//        }
//        answer.add(root.val);
//        dfsPre(root.left, answer);
//        dfsPre(root.right, answer);
//    }
//     no recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            answer.add(current.val);
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
        return answer;
    }
}
