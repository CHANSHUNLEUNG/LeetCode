package Questions.TwoPointers.question141;

public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode firstClone = head, secondClone = head.next;
        while(true){
            if(secondClone != null && secondClone.next != null){
                if(firstClone == secondClone){
                    return true;
                }
                firstClone = firstClone.next;
                secondClone = secondClone.next.next;
            }else{
                return false;
            }
        }
    }
}
