package 合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        for (int i = 0; i < lists.length; i++) {
            while (lists[i]!=null){
                queue.add(lists[i]);
                lists[i]=lists[i].next;
            }
        }
        ListNode head=dummy;
        while (!queue.isEmpty()){
            head.next=queue.poll();
            head=head.next;
        }
        head.next=null;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        Solution solution = new Solution();
        System.out.println(solution.mergeKLists(lists));
    }
}
