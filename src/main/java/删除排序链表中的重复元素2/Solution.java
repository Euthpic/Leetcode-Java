package 删除排序链表中的重复元素2;

/**
 * 跟数组去重一样,都是快慢指针的做法,不过这里需要注意的是重复的元素是全部删除,而非保留一个.
 * 由于链表是单向的,所以这里额外用了一个前置链表,用来判断当前节点与前后节点是否重复.
 * fast.next == null || fast.val != fast.next.val 表示与后节点不重复,特例是后节点为空.
 * pre.val == dump.val || pre.val != fast.val 表示与前节点不重复,特例是当前节点为头节点
 */
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
        if (head == null || head.next == null) return head;
        ListNode dump = new ListNode(-101, head);
        ListNode slow = dump;
        ListNode fast = head;
        ListNode pre = dump;
        while (fast != null) {
            if ((fast.next == null || fast.val != fast.next.val) && (pre.val == dump.val || pre.val != fast.val)) {
                slow.next = fast;
                slow = fast;
            }
            pre = pre.next;
            fast = fast.next;
        }
        //注意链表要以null收尾,不然可能出现链表后面全部是重复的但没有删除的情况
        slow.next = null;
        return dump.next;
    }


}
