package 旋转数组找值.q154_寻找旋转排序数组中的最小值_II;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len <= 0) return -1;
        if(len == 1) return nums[0];
        int l =0;
        int r = nums.length-1;
        int m;

        // 第二种情况是存在旋转
        while(l < r) {
            // *** 这个题是把它直接写在里面的循环了，如果存在有序就直接返回最左边，因为后面通过了lm和rm去重了
            // 第一种情况如果是有序的，没有旋转
            if(nums[l] < nums[r]){
                return nums[l];
            }
            m = l + (r-l)/2;
            int lm =m;
            int rm =m;
            while(lm>0 && nums[lm] == nums[lm-1] ){
                lm--;
            }
            if( lm>0 && nums[lm] < nums[lm-1]){
                return nums[lm];
            }
            while(rm<len-1 && nums[rm] == nums[rm+1]){
                rm++;
            }
            if(rm<len-1 && nums[rm] > nums[rm+1]){
                return nums[rm+1];
            }
            if(nums[m] > nums[l]){
                l=rm+1;
            } else if(nums[m] < nums[l]){
                r=lm-1;
            } else {
                l++;
            }
        }


        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {10,1,10,10,10};
        System.out.println(new Solution().findMin(nums));
    }
}
