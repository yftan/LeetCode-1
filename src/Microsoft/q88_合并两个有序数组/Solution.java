package Microsoft.q88_合并两个有序数组;

public class Solution {
    /**
     * 这个因为nums1有足够的空间，所以从后往前考虑，不需要移动了。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int sum = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[sum--] = nums1[i--];
            } else {
                nums1[sum--] = nums2[j--];
            }
        }
        // 这句不需要加了，本来就是nums1的
        // while (i >=0) {
        //     nums1[sum--] = nums1[i--];
        // }
        while (j >=0) {
            nums1[sum--] = nums2[j--];
        }
    }
}
