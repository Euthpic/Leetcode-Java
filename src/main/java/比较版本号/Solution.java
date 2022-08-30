package 比较版本号;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int maxLen = Math.max(len1, len2);
        int cur = 0;
        while (cur < maxLen) {
            if (cur > len1 - 1) {
                int num = Integer.parseInt(arr2[cur]);
                if (num != 0) {
                    return -1;
                }

            } else if (cur > len2 - 1) {
                int num = Integer.parseInt(arr1[cur]);
                if (num != 0) {
                    return 1;
                }
            } else {
                int num1 = Integer.parseInt(arr1[cur]);
                int num2 = Integer.parseInt(arr2[cur]);
                if (num1 > num2) {
                    return 1;
                } else if (num2 > num1) {
                    return -1;
                }
            }
            cur++;
        }
        return 0;
    }
}
