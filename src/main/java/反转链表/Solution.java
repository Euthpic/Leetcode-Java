package 反转链表;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = null;
        ListNode pre = head;
        ListNode next = head.next;
        while (pre != null) {
            pre.next = cur;
            cur = pre;
            pre = next;
            if (next!=null){
                next = next.next;
            }
        }
        return cur;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
