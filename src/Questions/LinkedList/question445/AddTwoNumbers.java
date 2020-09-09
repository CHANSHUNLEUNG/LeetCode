package Questions.LinkedList.question445;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode();
        dummy1.next = l1;
        ListNode dummy2 = new ListNode();
        dummy2.next = l2;
        String str1 = "";
        String str2 = "";
        while (dummy1.next != null) {
            dummy1 = dummy1.next;
            str1 += String.valueOf(dummy1.val);
        }
        while (dummy2.next != null) {
            dummy2 = dummy2.next;
            str2 += String.valueOf(dummy2.val);
        }
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int carry = 0;
        String value = "";
        for (int index = 0; index < str1.length(); index++) {
            int number1 = str1.charAt(str1.length() - index - 1) - '0';
            int number2 = 0;
            if (str2.length() - index - 1 >= 0) {
                number2 = str2.charAt(str2.length() - index - 1) - '0';
            }
            value = (number1 + number2 + carry) % 10 + value;
            carry = number1 + number2 + carry >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            value = "1" + value;
        }
        ListNode dummy = new ListNode();
        ListNode dummyHead = dummy;
        for (int index = 0; index < value.length(); index++) {
            ListNode current = new ListNode(value.charAt(index) - '0');
            dummy.next = current;
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}
