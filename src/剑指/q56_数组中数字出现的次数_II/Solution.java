package 剑指.q56_数组中数字出现的次数_II;

public class Solution {
    public int singleNumber(int[] nums) {
        int one =0;
        int two =0;
        for(int i=0; i < nums.length;i++) {
            one = ~two & (one ^ nums[i]);
            two = ~one & (two ^ nums[i]);
        }
        return one;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,3,3};
        new Solution().singleNumber(arr);
    }
}
