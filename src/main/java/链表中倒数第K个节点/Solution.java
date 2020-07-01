package 链表中倒数第K个节点;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail=head;
        for (int i = 1; i <k ; i++) {
            if (head.next==null){
                return null;
            }
            tail=tail.next;
        }
        while (tail.next!=null){
            tail=tail.next;
            head=head.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
