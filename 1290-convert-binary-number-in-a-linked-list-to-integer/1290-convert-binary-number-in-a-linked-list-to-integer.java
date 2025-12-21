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
    public int getDecimalValue(ListNode head) {
        // TC = O(N)
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        // TC = O(N)
        int ctr = n-1, ans = 0;
        curr = head;
        while (curr != null) {
            if (curr.val == 1) {
                ans += (1 << ctr);
            }
            ctr--;
            curr = curr.next;
        }
        return ans;
    }
}