package 删除链表的节点;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }
        if (head.val==val){
            return head.next;
        }

        ListNode res=head;
        while (head.next!=null){
            if (head.next.val==val){
                head.next=head.next.next;
                break;
            }
            head=head.next;
        }
        return res;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
