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
    static class Block {
        ListNode node;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;

        int k = lists.length;
        // this is the no of lists

        Queue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);    // min heap as small to large we want
        
        // put all the heads inside the PQ
        for (int i=0; i<k; i++) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
                node.next = null;
            }
            if (head == null) {                
                head = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }
        return head;
    }
}