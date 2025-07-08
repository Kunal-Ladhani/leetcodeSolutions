/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        return better(head);
    }

    // tc = O(N), sc = O(N)
    public boolean naive(ListNode head) {
        boolean ans = false;
        Set<ListNode> seen = new HashSet<>();
        for(ListNode curr = head; curr != null; curr = curr.next) {
            if (seen.contains(curr)) {
                return true;
            }
            seen.add(curr);
        }
        return ans;
    }

        // tc = O(N), sc = O(1)
    public boolean better(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}