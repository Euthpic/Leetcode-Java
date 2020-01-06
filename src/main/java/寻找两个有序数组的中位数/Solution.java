package 寻找两个有序数组的中位数;

import java.util.ArrayList;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return handleNull(nums1, nums2);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                list.add(nums2[j++]);
                continue;
            }
            if (j >= nums2.length) {
                list.add(nums1[i++]);
                continue;
            }
            int tmp = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            list.add(tmp);
        }
        if (list.size() % 2 == 0) {
            return ((double) list.get(list.size() / 2 - 1) +
                    list.get(list.size() / 2))
                    / 2;
        } else {
            return list.get(list.size() / 2);
        }
    }

    private double handleNull(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            if (nums2.length % 2 == 0) {
                return ((double) nums2[nums2.length / 2 - 1] +
                        nums2[nums2.length / 2])
                        / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        }

        if (nums1.length % 2 == 0) {
            return ((double) (nums1[nums1.length / 2 - 1] +
                    nums1[nums1.length / 2])
                    / 2);
        } else {
            return nums1[nums1.length / 2];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums2 = {1, 3};
        int[] nums1 = {2, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

    }
}
