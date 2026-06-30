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
        // return evenOddWithoutDummy(head);    
        
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenStart = even, evenEnd = even;
        ListNode oddStart = odd, oddEnd = odd;

        ListNode curr = even.next;
        int pos = 3;
        
        while (curr != null) {
            if (pos % 2 == 1) {
                // odd position node
                oddEnd.next = curr;
                oddEnd = oddEnd.next;
            } else {
                // even position node
                evenEnd.next = curr;
                evenEnd = evenEnd.next;
            }
            curr = curr.next;
            pos++;
        }

        evenEnd.next = null;
        oddEnd.next = evenStart;
        
        return oddStart;
    }
}