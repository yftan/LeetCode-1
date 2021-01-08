package 数组操作.q907_子数组的最小值之和;

/**
 * 与152题目类似
 *
 */
public class Solution {
    /**
     * 超时了
     */
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)Math.pow(10,9) +7;
        int len = arr.length;
        if(len <= 0) return -1;
        long sum  = 0;
        for(int i=1; i <= len; i++) {
            for(int j=0; j< len -i +1; j++){
                long min = Integer.MAX_VALUE;
                for(int k=j; k < j+i ; k++) {
                    long tmp = arr[k];
                    if(tmp < min) {
                        min = tmp;
                    }
                }
                sum += min;
                sum %= mod;
            }
        }
        return (int)sum;
    }


}
