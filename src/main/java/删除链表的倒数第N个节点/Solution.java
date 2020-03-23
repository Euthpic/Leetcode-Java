package 删除链表的倒数第N个节点;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode next = head;
        while (next != null && n > 0) {
            next = next.next;
            n--;
        }
        //如果n大于链表长度
        if (next == null && n > 0) {
            return head;
        }
        if (next == null && n == 0) {
            return head.next;
        }
        ListNode pre = head;
        ListNode after = head;
        while (next != null) {
            pre = after;
            after = after.next;
            next = next.next;
        }
        pre.next=after.next;
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
