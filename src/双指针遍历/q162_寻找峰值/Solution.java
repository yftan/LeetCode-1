package 双指针遍历.q162_寻找峰值;

public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        if (len == 2) {
            return nums[0] > nums[1] ? 0 :1;
        }

        int left = -1;
        int mid = 0;
        int right = 1;
        while(mid < len){
            if(left == -1) {
                if(nums[mid] > nums[right]) return mid;
            } else if(right == len) {
                if(nums[mid] > nums[left]) return mid;
            } else if(nums[mid] > nums[left] && nums[mid] >nums[right] ){
                return mid;
            }
            left++;
            mid++;
            right++;
        }
        return 0;
    }
}
