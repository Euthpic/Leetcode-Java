package 合并两个有序数组;

/**
 * 常规方法是遍历nums1,从前往后排,但是这样需要往数组里插入元素,耗时长
 * 转变一下思路,就像头号玩家里向后开,考虑从后往前排,由于num1后面是空的,因此无需插入,直接赋值
 * 从前往后排,比较的是谁小;从后往前排,比较的是谁大
 * 那么如果遍历到nums1前面,直接覆盖原来的值没有影响吗?
 * 答案是不会.对于nums1的某个具体元素而言,合并之后它的位置只会往后移或者原地停留,
 * 不会向前,因为前面比它小的数只会更多而不会更少.
 * 所以从后往前排的过程中,遍历到某个位置时,它的值已经赋值到后面位置了,可以直接覆盖
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1;
        int l2 = n - 1;
        int r = nums1.length - 1;
        while (r >= 0) {
            if (l1 < 0) {
                nums1[r] = nums2[l2];
                l2--;
                r--;
            } else if (l2 < 0) {
                nums1[r] = nums1[l1];
                l1--;
                r--;
            } else {
                if (nums1[l1] >= nums2[l2]) {
                    nums1[r] = nums1[l1];
                    l1--;
                    r--;
                } else {
                    nums1[r] = nums2[l2];
                    l2--;
                    r--;
                }
            }
        }
    }
}
