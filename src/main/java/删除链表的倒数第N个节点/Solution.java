package 删除链表的倒数第N个节点;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            return null;
        }
        if (n == 1) {
            return head;
        }
        ListNode next = head.next;
        while (next != null && n > 1) {
            next = next.next;
            n--;
        }
        //链表长度小于n
        if (next == null && n > 1) {
            return null;
        }
        while (next.next!=null){

        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
