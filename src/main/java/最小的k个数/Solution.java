package 最小的k个数;

import java.util.Arrays;

public class Solution {
    private int[] arr;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        this.arr = arr;
        return quickSort(0, arr.length - 1, k - 1);
    }

    private int[] quickSort(int lo, int hi, int k) {
        int j = partition(lo, hi);
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j > k ? quickSort(lo, j-1, k) : quickSort(j+1, hi, k);
    }

    private int partition(int lo, int hi) {
        int v = arr[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < v) ;
            while (--j >= lo && arr[j] > v) ;
            if (i>=j) {
                break;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;
    }
}
