package Questions.tree.question109;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode backupHead = head;
        ListNode middle = getMiddle(head);
        TreeNode root = new TreeNode(middle.val);
        TreeNode right = sortedListToBST(middle.next);
        while (head.next != null && head.next != middle) {
            head = head.next;
        }
        head.next = null;
        TreeNode left = sortedListToBST(backupHead);
        root.left = left;
        root.right = right;
        return root;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
