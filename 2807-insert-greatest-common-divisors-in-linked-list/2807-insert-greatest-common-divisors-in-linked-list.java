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
    private int gcd(int a, int b) {
        if (a == 0) 
            return b; 
        if (b == 0) 
            return a; 
        // base case 
        if (a == b) 
            return a; 
        // a is greater 
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode curr = head;
        while(curr.next != null) {
            
            ListNode newNode = new ListNode(gcd(curr.val, curr.next.val));    
            newNode.next = curr.next;
            curr.next = newNode;
                
            curr = newNode.next;
        }
        return head;
    }
}

// 1->2->3->4->5
// n-1 links so we need to insert n-1 nodes
