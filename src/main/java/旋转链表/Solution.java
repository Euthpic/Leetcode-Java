package 旋转链表;

/**
 * 向右移k个位置,也就是把链表末尾的k个节点挪到前面,也就是让n-k%n (n为链表长度)的节点成为新的头节点
 * 先把链表连成环,然后从n-k%n的节点处断开,让它成为新的头节点.
 * 还是那句话,链表的题思路很简单,难的是实现过程
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 | head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        int len = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        int add = len - k % len;
        //k是len的倍数,也就是从头节点开始移n趟,相当于不用移
        if (add == 0) {
            return head;
        }
        tmp.next = head;
        while (add > 0) {
            tmp = tmp.next;
            add--;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;

    }

}
