package Microsoft.q283_移动零;

public class Solution {
    public void moveZeroes(int[] nums) {
        // 时刻记录出现0的位置，每个元素都向前移动n个0的位置即可
        int len = nums.length;
        int count = 0;
        for(int i=0; i< len ; i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                nums[i-count]= nums[i];
            }
        }
        for(int i=len-count; i < len;i++) {
            nums[i] = 0;
        }
    }
}
