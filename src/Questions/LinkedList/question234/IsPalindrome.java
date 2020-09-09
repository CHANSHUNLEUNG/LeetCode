package Questions.LinkedList.question234;


public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        if (fast == null) {
            slow = slow.next;
        }
        return isEqual(head, reverse(slow));
    }

    private boolean isEqual(ListNode head, ListNode slow) {
        while (head != null && slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(head.next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
    }

}
