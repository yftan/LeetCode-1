package 旋转数组找值.q33_搜索旋转排序数组;

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len <=0) return -1;
        int l=0;
        int r=nums.length-1;
        int m ;
        while(l<=r){
            m = l + (r-l)/2;
            if(nums[m] == target) return m;
            // nums[l] < nums[m]证明在该区间是有序的
            // 这个等号非常重要
            if( nums[l] <= nums[m]){
                // 这个等号非常重要，与边界比较的时候等号必须要考虑进去
                if(target >= nums[l] && target < nums[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                // 这个等号非常重要
                if( target <= nums[r] && target > nums[m]){
                    l = m+1;
                } else {
                    r= m-1;
                }
            }
        }
        return -1;
    }
}