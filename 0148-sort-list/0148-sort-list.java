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
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head; 
        }
        
        List<Integer> temp = new ArrayList<>(); // O(N)
        ListNode curr = head;
        while (curr != null) {
            temp.add(curr.val);
            curr = curr.next;
        }
        
        Collections.sort(temp); // O(NlogN)
        
        curr = head;
        int idx = 0;
        while (curr != null) {
            curr.val = temp.get(idx++);
            curr = curr.next;
        }
        
        return head;
    }
}