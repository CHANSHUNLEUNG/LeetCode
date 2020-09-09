package Questions.LinkedList.question24;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        swapPairsFunction(dummy, dummy.next, 0);
        return dummy.next;
    }

    private void swapPairsFunction(ListNode pre, ListNode head, int count) {
        if (head == null || head.next == null) {
            return;
        }
        count++;
        swapPairsFunction(head, head.next, count);
        if (count % 2 == 1) {
            ListNode nextCopy = head.next;
            head.next = head.next.next;
            nextCopy.next = head;
            pre.next = nextCopy;
        }
    }

    public static void main(String[] argv) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = second;
        first.next = second;
        first.next = first.next.next;

        System.out.println(second.val);
    }
}
