class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) return dummy.next;

            // Reversal
            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            reverse(groupStart, groupNext);

            groupPrev.next = kth;

            groupPrev = groupStart;
            
        }
    }

    private ListNode getKth(ListNode curr, int k) {

        // Repeat k times
        for (int i = 0; i < k; i++) {
            curr = curr.next;

            if (curr == null) return null;
        }
        return curr;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode curr = start;
        // Initialise prev to groupNext instead of null to reconnect
        ListNode prev = end;

        while (curr != end) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
    }

}
