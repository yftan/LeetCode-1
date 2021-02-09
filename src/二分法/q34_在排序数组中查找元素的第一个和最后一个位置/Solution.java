package 二分法.q34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * 二分法查找系列题目：
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-ymwl/
 *
 */
public class Solution {
    int index = -1;
    public int[] searchRange(int[] nums, int target) {
        // use binary search
        int[] res = new int[2];
        binarySearch(nums, target, 0, nums.length-1);
        if(nums == null || nums.length <=0 || index == -1) {
            res[0] = index;
            res[1] = index;
        } else {
            int left = index, right = index;
            while(left >=0 && nums[left] == target) {
                left--;
            }
            while(right<nums.length && nums[right] == target ) {
                right++;
            }
            res[0] = left+1;
            res[1] = right-1;
        }
        return res;
    }

    public void binarySearch(int[] nums, int target, int left, int right){
        if(left > right) return;
        int mid = left + (right - left) /2;
        if(nums[mid] == target){
            index = mid;
            return;
        } else if(nums[mid] > target){
            binarySearch(nums, target, left, mid-1);
        } else {
            binarySearch(nums, target, mid+1, right);
        }
    }
}
