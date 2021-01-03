package 竞赛.深信服.q5642_大餐计数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD = (int)Math.pow(10,9) + 7;
        Map<Integer, Integer> map = new HashMap<>();
        int len = deliciousness.length;
        int count=0;
        for(int i=0; i< len;i++){
            //放在循环前面不对，要先去查找是否有符合要求的值，然后再将本身放入。 map.put(deliciousness[i], map.getOrDefault(deliciousness[i],0)+1);
            //由于0 <= deliciousness[i] <= 2^20，在这个区间中两个deliciousness相加符合要求的值只有2^0~2^21,22钟可能
            int sum=1;
            for(int j=0; j< 22; j++) {
                if((sum-deliciousness[i]) >=0 && map.get(sum-deliciousness[i]) !=null){
                    count+= map.get(sum-deliciousness[i]);
                    count %= MOD;
                }
                sum *=2;
            }
            // 这个地方放在内部的循环后面，是因为每到一个新的deliciousness[i]，要判断i-1之前有没有符合的值。
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i],0)+1);
        }
        return count%MOD;
    }

    /**
     * 暴力解法（超时）
     * @param deliciousness
     * @return
     */
    public int countPairs1(int[] deliciousness) {
        int count =0;
        int len = deliciousness.length;
        for(int i=0; i< len-1;i++){
            for(int j=i+1; j< len;j++){
                int sum = deliciousness[i] + deliciousness[j];
                if(sum >0 && (sum & (sum-1))==0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] deliciousness = new int[]{1,3,5,7,9};
        new Solution().countPairs(deliciousness);
    }

}
