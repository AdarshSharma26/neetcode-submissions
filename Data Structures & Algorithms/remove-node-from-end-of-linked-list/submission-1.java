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
        // Create dummy node to safely manage removing the first (head) node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Advance the fast pointer forward n + 1 steps to create the proper gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers forward at the same speed until fast hits the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Delete the node by severing its reference and pointing to the next one
        slow.next = slow.next.next;
        
        // Return the true head of the modified list
        return dummy.next;
    }
}
