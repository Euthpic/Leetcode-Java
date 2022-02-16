package 分隔链表;

/**
 * 注意体会本题中对链表的"断尾"操作
 */
public class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode smallHead=new ListNode(-1,head);
        ListNode small=smallHead;
        ListNode largeHead=new ListNode(-1,head);
        ListNode large=largeHead;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val<x){
                small.next=cur;
                small=small.next;
            }else{
                large.next=cur;
                large=large.next;
            }
            cur=cur.next;
        }
        large.next=null;
        small.next=largeHead.next;
        return smallHead.next;
    }
}
