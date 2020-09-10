package Questions.tree.question145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> answer = new ArrayList();
//        dfsPost(root, answer);
//        return answer;
//    }
//
//    private void dfsPost(TreeNode root, List<Integer> answer) {
//        if(root == null){
//            return;
//        }
//        dfsPost(root.left,answer);
//        dfsPost(root.right,answer);
//        answer.add(root.val);
//    }
//    no recusion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList();
        if(root == null){
            return answer;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
            answer.add(current.val);
        }
        Collections.reverse(answer);
        return answer;
    }

}
