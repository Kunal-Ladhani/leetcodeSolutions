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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) { 
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;    
        }
        
        ListNode curr = null, ans = null;
        
        if (l1.val < l2.val) {
            curr = l1;
            l1 = l1.next;
        } else { 
            curr = l2;
            l2 = l2.next;
        }
        
        ans = curr;
        
        while (l1 != null && l2 != null) {
        
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
            
        }
        
        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;            
        }
        
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        
        return ans;
    }
}