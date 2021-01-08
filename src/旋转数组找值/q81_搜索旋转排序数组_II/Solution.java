package 旋转数组找值.q81_搜索旋转排序数组_II;

public class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len <= 0) return false;
        if(len == 1) return nums[0] == target;
        int l = 0;
        int r = len-1;
        int m ;
        //  这里是大于等于
        while(l <= r){
            m = l + (r-l)/2;
            if(nums[m] == target) return true;

            // 证明l到m是单调递增的
            if(nums[m] > nums[l]){
                // 证明在有序区间内
                if(nums[m] > target && target >= nums[l]) {
                    r=m;
                } else {
                    l=m+1;
                }
                // 证明有旋转
            } else if(nums[m] < nums[l]){
                if(nums[m] < target &&  target <= nums[r]) {
                    l=m+1;
                } else {
                    r= m;
                }
            } else if(nums[m] == nums[l]) {
                l++;
            }
        }
        return false;
    }
}
