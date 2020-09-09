package Questions.LinkedList.question160;

import java.util.HashMap;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headACopy = headA, headBCopy = headB;
        while (headACopy != headBCopy) {
            headACopy = headACopy == null ? headB : headACopy.next;
            headBCopy = headBCopy == null ? headA : headBCopy.next;
        }
        return headACopy;
    }

    public static void main(String[] argv) {
        ListNode[] test = new ListNode[10];
        System.out.println(test[1]);
    }
}
