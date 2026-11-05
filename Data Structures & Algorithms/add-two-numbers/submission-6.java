/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0; // can never be more than 1. because we're adding single digits
        while (l1 != null || l2 != null || carry != 0) { // 6 -> 1 + 4 -> 1
            int d1 = 0;
            int d2 = 0;
            if (l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }

            int digitSum = d1 + d2 + carry;
            int d3 = digitSum % 10;
            carry = digitSum / 10;
            
            curr.next = new ListNode(d3);
            curr = curr.next;
        }
        return dummy.next;
    }
}
