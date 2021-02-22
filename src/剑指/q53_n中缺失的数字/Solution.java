package 剑指.q53_n中缺失的数字;

public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().missingNumber(new int[]{0,1,3});
    }
}
