package Questions.LinkedList.question83;

public class DeleteDuplicates {
    //    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        int lastValue = head.val;
//
//        ListNode answerHead = new ListNode(head.val);
//        ListNode answer = answerHead;
//
//        while (dummy.next != null) {
//            dummy = dummy.next;
//            if (dummy.val == lastValue) {
//                continue;
//            } else {
//                answer.next = new ListNode(dummy.val);
//                lastValue = dummy.val;
//                answer = answer.next;
//            }
//        }
//        return answerHead;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null && head.next.val == head.val) {
            head.next = head.next.next;
        }
        deleteDuplicates(head.next);
        return head;
    }
}
