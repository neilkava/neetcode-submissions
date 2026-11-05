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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        recursiveAdd(l1, l2, 0, curr);
        return dummy.next;
    }

    private void recursiveAdd(ListNode l1, ListNode l2, int carry, ListNode curr) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        
        int d1 = 0, d2 = 0;
        if (l1 != null) {
            d1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            d2 = l2.val;
            l2 = l2.next;
        }

        int d3 = d1 + d2 + carry;
        curr.next = new ListNode(d3 % 10);
        curr = curr.next;
        recursiveAdd(l1, l2, d3 / 10, curr);
    }
}
