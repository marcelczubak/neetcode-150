import java.util.*;

class Solution {

    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Node curr = head;
        
        // 1. Traverse linked list, add all node copies as values to a hashmap

        Map<Node, Node> hashmap = new HashMap<>();

        while (curr != null) {
            Node copy = new Node(curr.val);
            hashmap.put(curr, copy);
            curr = curr.next;
        }

        // 2. Iterate linked list, add pointers in copy list
        curr = head;

        while (curr != null) {
            Node next = curr.next;
            Node random = curr.random;

            Node currCopy = hashmap.get(curr);

            currCopy.random = hashmap.get(random);
            currCopy.next = hashmap.get(next);

            curr = curr.next;

        }

        return hashmap.get(head);


    }
}
