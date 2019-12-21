package LeetCode;


import java.math.BigInteger;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // First time around I returned the number in correct order... apparently it wants it reversed... aight
    // Also these numbers are not integers on input
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both lists
        // Iterate to create number
        // Add
        ListNode number1 = reverse(l1);
        ListNode number2 = reverse(l2);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while(number1 != null){
            num1.append(number1.val);
            number1 = number1.next;
        }
        while(number2 != null){
            num2.append(number2.val);
            number2 = number2.next;
        }
        BigInteger toAdd1 = new BigInteger(num1.toString());
        BigInteger toAdd2 = new BigInteger(num2.toString());
        BigInteger sum = toAdd1.add(toAdd2);
        String sumString = sum.toString();
        ListNode head = new ListNode(sumString.charAt(0) - '0');
        ListNode ans = head;
        for(int i =1; i<sumString.length(); i ++){
            int digit = sumString.charAt(i) - '0'; // get numeric value
            ListNode currDigit = new ListNode(digit);
            head.next = currDigit;
            head = head.next;
        }

        return reverse(ans);

    }

}
