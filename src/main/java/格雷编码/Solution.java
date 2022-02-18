package 格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * 背公式就完事了
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < 1<<n ; i++) {
            res.add(i ^  i>>1);
        }
        return res;
    }
}
