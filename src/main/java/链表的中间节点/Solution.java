package 链表的中间节点;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            if (fast.next==null){
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
