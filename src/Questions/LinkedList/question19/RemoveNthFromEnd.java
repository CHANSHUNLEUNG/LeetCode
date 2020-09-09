package Questions.LinkedList.question19;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        changeNthFromEnd(dummy, n);
        return dummy.next;
    }

    public int changeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return 1;
        }
        int nth = 1 + changeNthFromEnd(head.next, n);
        if (nth == n + 1) {
            head.next = head.next.next;
        }
        return nth;
    }
}
