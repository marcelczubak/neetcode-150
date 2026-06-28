class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
    
        while (fast != null && fast.next != null) {

            // move slow 1 step
            slow = slow.next;

            // move fast 2 steps
            fast = fast.next.next;
            
            // check if pointers meet
            if (fast == slow) return true;
        }
        return false;
    }
}
