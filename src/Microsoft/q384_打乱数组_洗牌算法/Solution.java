package Microsoft.q384_打乱数组_洗牌算法;

import java.util.Random;

public class Solution {

    int[] original_nums;
    int[] nums;

    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        original_nums = new int[len];
        for(int i=0;i< len;i++){
            original_nums[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original_nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index1 = rand.nextInt(len);
            int index2 = rand.nextInt(len);
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
        return nums;
    }
}
