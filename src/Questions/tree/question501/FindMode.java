package Questions.tree.question501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMode {
    private List<Integer> answerList = new ArrayList<>();
    private TreeNode preNode = null;
    private int maxFrequency = 1;
    private int currentFrequency = 1;

    public int[] findMode(TreeNode root) {
        dfsIn(root);
        int[] answer = new int[this.answerList.size()];
        for (int index = 0; index < answerList.size(); index++) {
            answer[index] = this.answerList.get(index);
        }
        return answer;
    }

    private void dfsIn(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsIn(root.left);
        if (preNode != null) {
            if (root.val == preNode.val) {
                currentFrequency++;
            } else {
                currentFrequency = 1;
            }
        }
        if (currentFrequency > maxFrequency) {
            maxFrequency = currentFrequency;
            answerList = new ArrayList<>(Arrays.asList(root.val));
        } else if (currentFrequency == maxFrequency) {
            answerList.add(root.val);
        }
        preNode = root;
        dfsIn(root.right);
    }
}
