package 合并K个排序链表;

import java.util.ArrayList;


public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode l1 = lists[0];
        ListNode l2 = lists[1];
        if (lists.length > 2) {
            ArrayList<ListNode> listNodes1 = new ArrayList<>();
            ArrayList<ListNode> listNodes2 = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                if (i < lists.length / 2) {
                    listNodes1.add(lists[i]);
                } else {
                    listNodes2.add(lists[i]);
                }
            }
            l1 = mergeKLists( listNodes1.toArray(new ListNode[0]));
            l2 = mergeKLists( listNodes2.toArray(new ListNode[0]));
        }
        return mergeTwoLists(l1, l2);
    }

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
