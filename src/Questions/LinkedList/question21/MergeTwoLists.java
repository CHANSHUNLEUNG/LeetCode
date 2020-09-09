package Questions.LinkedList.question21;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] argv) {
        ListNode test1 = new ListNode(1);
        ListNode answer = new ListNode(2);
        ListNode test2 = answer;
        answer.next = test1;
        answer = answer.next;
        System.out.println(test2.val);
        System.out.println(answer.val);
    }
}
