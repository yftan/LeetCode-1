package 数组操作.q152_乘积最大子数组;

/**
 * 与907类似
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        if(len ==1 ) return nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=0; i < len; i++) {
            int multi = 1;
            for(int j=i; j<len; j++ ){
                multi *= nums[j];
                if(multi > max) {
                    max = multi;
                }
            }
        }
        return max;
    }
}
