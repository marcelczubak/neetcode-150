import java.util.*;

class Solution {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {


        List<ListNode> current = new ArrayList<>();

        // Convert array[] to a List
        for (ListNode node : lists) {
            current.add(node);
        }

        while (current.size() > 1) {

            List<ListNode> merged = new ArrayList<>();

            for (int i = 0; i < current.size(); i += 2) {

                if (i < current.size() - 1) {
                    merged.add(merge(current.get(i), current.get(i + 1)));
                } else {
                    merged.add(current.get(i));
                }
            }

            current = merged;
        }

        return current.isEmpty() ? null : current.get(0);

    }

    // Merging two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        

        return dummy.next;

    }
}
