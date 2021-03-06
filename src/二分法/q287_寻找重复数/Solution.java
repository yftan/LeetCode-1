package 二分法.q287_寻找重复数;

/**
 * 思路：
 *
 * 这道题要求我们查找的数是一个整数，并且给出了这个整数的范围（在 11 和 nn 之间，包括 1 和 n），并且给出了一些限制，于是可以使用二分查找法定位在一个区间里的整数；
 *
 * 二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），然后统计原始数组中小于等于这个中间数的元素的个数 cnt，如果 cnt 严格大于 mid，（注意我加了着重号的部分「小于等于」、「严格大于」）。根据抽屉原理，重复元素就在区间 [left, mid] 里；
 *
 * 与绝大多数二分法问题的不同点是：正着思考是容易的，即：思考哪边区间存在重复数是容易的，因为有抽屉原理做保证。我们通过一个具体的例子来分析应该如何编写代码；
 *
 * 以 [2, 4, 5, 2, 3, 1, 6, 7] 为例，一共 8 个数，n + 1 = 8，n = 7，根据题目意思，每个数都在 1 和 7 之间。
 *
 * 例如：区间 [1, 7][1,7] 的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，如果不存在重复元素，最多为 4 个。等于 4 的时候区间 [1, 4] 内也可能有重复元素。但是，如果整个数组里小于等于 4 的整数的个数严格大于 4 的时候，就可以说明重复的数存在于区间 [1, 4]。
 *
 * 说明：由于这个算法是空间敏感的，「用时间换空间」是反常规做法，算法的运行效率肯定不会高。
 *
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length -1;
        while(left < right) {
            // 随便找个中间值，因为范围是1-n的
            int mid = left + (right-left) /2;
            int cnt =0;
            for(int val: nums) {
                if(val <= mid) {
                    cnt++;
                }
            }

            // 如果没有重复1-mid的数量应该是小于等mid的，例如1-3，那么数量最多就是3个。如果大于它证明存在重复值
            if(cnt > mid) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int findDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while(nums[i]-1 != i && nums[i]-1 < len && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
            if(nums[i]-1 != i) {
                return nums[i];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,9,6,9,3,8,9,7,1};
        int duplicate1 = new Solution().findDuplicate1(nums);
    }
}
