package 比较版本号;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            int a = 0;
            int b = 0;
            if (i < n) {
                a = Integer.parseInt(arr1[i++]);
            }
            if (j < m) {
                b = Integer.parseInt(arr2[j++]);
            }
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }
}
