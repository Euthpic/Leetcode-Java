package 复杂链表的复制;

import java.util.HashMap;

public class Solution {
    private HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);

        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }


    class Node {
        int val;
        Node next;
        Node random;

        private Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
