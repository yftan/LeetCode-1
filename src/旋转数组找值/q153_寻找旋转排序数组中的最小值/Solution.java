package 旋转数组找值.q153_寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        if(len == 1) return nums[0];
        int l = 0;
        int r = len-1;
        int m ;
        // 首先判断数组是否旋转，如果最后的值大于最前面的值，则没有旋转
        // 这个与154不同的地方就是它是没有重复的，所以有序无序通过起始点就可以直接判断。
        // 而有重复的就需要每次都去判断是否是有序的才行
        if(nums[r] > nums[0] ) {
            return nums[0];
        }
        while(l <= r){
            m = l + (r-l)/2;
            // 寻找改变的点，改变的点，该点的特点是，它后面的值小于它。它前面的值大于它
            if(nums[m] > nums[m+1]){
                return nums[m+1];
            }
            if(nums[m-1] > nums[m]){
                return nums[m];
            }
            if(nums[m] > nums[l]){
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Solution().findMin(nums));
    }
}
