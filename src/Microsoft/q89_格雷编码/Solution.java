package Microsoft.q89_格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码实际上就是在二进制的最高位补0或补1
 *
 * 例如
 * n=0 0
 * n=1 1
 * n=2 00 01
 * n=3 000 001 100 101
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if(n == 0 ) return res;
        int head=1;
        for (int i=1; i<=n;i++) {
            int size = res.size();
            for(int j=size-1; j >= 0;j--) {
                res.add(res.get(j) + head);
            }
            head <<= 1;
        }
        return res;
    }
}
