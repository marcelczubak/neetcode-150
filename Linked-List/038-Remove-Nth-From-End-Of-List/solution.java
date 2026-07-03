

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        ListNode next = curr.next;

        int length = 1;

        while (next != null) {
            // advance all pointers
            curr = next; 
            next = next.next;
            length++;
        }

        // reach nth pointer from end
        int preRemove = length - n;

        if (preRemove == 0) return head.next;
        

        // reach preRemove node
        int count = 1;
        curr = head;

        while (count < preRemove) {
            curr = curr.next;
            count++;
        }

        next = curr.next.next;
        curr.next = next;

        return head;

    }
}
