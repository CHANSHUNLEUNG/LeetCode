package Questions.Others.question2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode firstPointer = l1, secondPointer = l2, currentPointer = dummy;
        int carry = 0;
        while(firstPointer != null || secondPointer != null){
            int firstNumber = (firstPointer != null) ? firstPointer.val : 0;
            int secondNumber = (secondPointer != null) ? secondPointer.val : 0;
            int sum = carry + firstNumber + secondNumber;
            carry = (sum >= 10) ? 1 : 0;
            if(firstPointer != null){
                firstPointer =firstPointer.next;
            }
            if(secondPointer != null){
                secondPointer = secondPointer.next;
            }
            currentPointer.next = new ListNode(sum % 10);
            currentPointer = currentPointer.next;
        }
        if(carry > 0){
            currentPointer.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static void main(String[] argv) {
    }
}
