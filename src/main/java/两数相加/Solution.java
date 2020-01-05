package 两数相加;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode next = new ListNode(0);
        head.next = next;
        while (true) {
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
            }
            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
            }
            ListNode node;
            if ((val1 + val2 + next.val) / 10 >= 1) {
                node = new ListNode(1);
            } else {
                node = new ListNode(0);
            }

            next.val = (val1 + val2 + next.val) % 10;


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                if (node.val != 0) {
                    next.next = node;
                }
                break;
            }
            next.next = node;
            next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
