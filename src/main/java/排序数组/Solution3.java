package 排序数组;

import java.util.Random;

//快速排序
//选定一个基准pivot,下标记为p,把小于它的元素放到左边,大于它的元素放到右边,那么就有[left,p)的元素 < pivot < (p,right]
//然后递归地去排序左右区间.当区间小于阈值时改用插入排序提高效率,这和归并排序是一样的.
//和归并不同的是快排不需要合并区间,归并是先小后大,先让小区间有序再合并成大区间;快排是先把数组分为小于pivot和大于pivot的两个大区间,然后再递归去划分区间
//基准值要随机选取,不然遇到正序或倒序的数组就会退化成选择排序,性能不稳定.
public class Solution3 {
    private static final int THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        //如果区间长度小于阈值则改用插入排序
        if (right - left <= THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        int pivot = nums[randomIndex];
        int lt = left;
        swap(nums, randomIndex, lt);
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > tmp) {
                nums[j] = nums[--j];
            }
            nums[j] = tmp;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
