public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps
            
            if (slow == fast) {       // Cycle detected
                return true;
            }
        }
        
        return false;                 // Fast pointer reached end (no cycle)
    }
}
