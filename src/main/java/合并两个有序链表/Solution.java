package 合并两个有序链表;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode next = new ListNode(0);
        head.next = next;
        while (true) {
            if (l1 == null) {
                next.next = l2;
                break;
            }
            if (l2 == null) {
                next.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            } else {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            }
        }
        return head.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
