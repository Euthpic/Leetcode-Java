package 分数到小数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder sb = new StringBuilder();
        if (numeratorLong * denominatorLong < 0) {
            sb.append("-");
        }
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        sb.append(numeratorLong / denominatorLong);
        sb.append(".");
        numeratorLong %= denominatorLong;
        Map<Long, Integer> map = new HashMap<>();
        while (numeratorLong != 0) {
            map.put(numeratorLong, sb.length());
            numeratorLong *= 10;
            sb.append(numeratorLong / denominatorLong);
            numeratorLong %= denominatorLong;
            if (map.containsKey(numeratorLong)) {
                int u = map.get(numeratorLong);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
