package 删除排序链表中的重复元素;

public class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null){
            if(fast.val!=slow.val){
                slow.next=fast;
                slow=fast;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
