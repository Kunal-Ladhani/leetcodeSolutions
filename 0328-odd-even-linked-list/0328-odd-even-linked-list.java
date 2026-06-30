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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode evenStart = head.next, evenEnd = head.next;
        ListNode oddStart = head, oddEnd = head;

        ListNode curr = head.next.next;
        boolean isOdd = true;
        
        while (curr != null) {
            if (isOdd) {
                // odd position node
                oddEnd.next = curr;
                oddEnd = oddEnd.next;
            } else {
                // even position node
                evenEnd.next = curr;
                evenEnd = evenEnd.next;
            }
            curr = curr.next;
            isOdd = !isOdd;
        }

        evenEnd.next = null;
        oddEnd.next = evenStart;
        
        return oddStart;
    }
}