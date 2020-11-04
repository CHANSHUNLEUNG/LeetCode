package jianzhi.Question18;

public class Delete {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode prev = dummy;
        while (pHead != null) {
            if(pHead.next != null && pHead.next.val == pHead.val){
                int current = pHead.val;
                while(pHead != null && pHead.val == current){
                    pHead = pHead.next;
                }
                prev.next = pHead;
            }else{
                prev = prev.next;
                pHead = pHead.next;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
