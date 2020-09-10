package Questions.tree.question572;

public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        return startWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean startWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return startWithRoot(s.left, t.left) && startWithRoot(s.right, t.right);
    }
}
