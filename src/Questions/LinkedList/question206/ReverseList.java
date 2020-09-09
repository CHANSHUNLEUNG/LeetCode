package Questions.LinkedList.question206;

import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode next = new ListNode(1, head);
        ListNode answer = null;
        while (next.next != null) {
            next = next.next;
            ListNode headOfNext = new ListNode(next.val);
            headOfNext.next = answer;
            answer = headOfNext;
        }
        return answer;
    }
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode next = head.next;
//        ListNode bottom = reverseList(next);
//        next.next = head;
//        head.next = null;
//        return bottom;
//    }

    public static void main(String[] argv) {
    }
}
