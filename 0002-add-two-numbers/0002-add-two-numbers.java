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
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0, sum  = 0;
        ListNode p1 = l1, p2 = l2, c = null, newNode = null, newHead = null;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            carry = sum/10;
            sum = sum%10;
            newNode = new ListNode(sum);
            if (c == null) {
                // first node
                c = newNode;
                newHead = c;
            } else {
                c.next = newNode;
                c = c.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            sum = p1.val + carry;
            carry = sum/10;
            sum = sum%10;
            c.next = new ListNode(sum);
            p1 = p1.next;
            c = c.next;
        }

        while (p2 != null) {
            sum = p2.val + carry;
            carry = sum/10;
            sum = sum%10;
            c.next = new ListNode(sum);
            p2 = p2.next;
            c = c.next;
        }

        if (carry != 0) {
            c.next = new ListNode(carry);
        }
        
        return newHead;
    }
}