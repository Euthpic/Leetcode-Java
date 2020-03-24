package 两两交换链表中的节点;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode left=head;
        ListNode right=head.next;
        ListNode pre=dummy;
        while (true){
            left.next=right.next;
            right.next=left;
            pre.next=right;
            ListNode tmp=left;
            left=right;
            right=tmp;
            if (right.next==null||right.next.next==null){
                break;
            }
            right=right.next.next;
            left=left.next.next;
            pre=pre.next.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
