package Questions.tree.question653;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sortedArray = new ArrayList<>();
        dfsIn(root, sortedArray);
        int start = 0, end = sortedArray.size() - 1;
        while (start < end) {
            int startVal = sortedArray.get(start);
            int endVal = sortedArray.get(end);
            if (k - startVal > endVal) {
                start++;
            } else if (k - startVal == endVal) {
                return true;
            } else {
                end--;
            }
        }
        return false;
    }

    private void dfsIn(TreeNode root, List<Integer> sortedArray) {
        if (root == null) {
            return;
        }
        dfsIn(root.left, sortedArray);
        sortedArray.add(root.val);
        dfsIn(root.right, sortedArray);
    }
}
