package 剑指offer.从尾到头打印链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(arr.length-i-1);
        }
        return arr;
    }
}
