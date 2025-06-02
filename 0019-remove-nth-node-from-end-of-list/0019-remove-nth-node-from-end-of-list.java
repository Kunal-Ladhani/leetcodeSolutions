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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // there is only 1 single node in list.
        if (head.next == null) {
            return null;
        }

        ListNode front = head;
        int count = 0;
        while (count < n) {
            front = front.next;
            count++;
        }

        if (front == null) {
            // means we want to remove head node
            head = head.next;
            return head;
        }

        ListNode rear = head;
        while (front.next != null) {
            front = front.next;
            rear = rear.next;
        }
        rear.next = rear.next.next;
        return head;
    }
}