package 竞赛.深信服.q5643_将数组分成三个子数组的方案数;

public class Solution1 {
    /**
     * ERROR：这道题没有做出来，边界关系没有分清楚
     *
     * @param nums
     * @return
     */
    public int waysToSplit(int[] nums) {
        // 使用前缀和+二分法
        int len = nums.length;
        int[] presum = new int[len+1];
        presum[0] = nums[0];
        for(int i=0;i<len;i++) {
            presum[i+1] = presum[i] + nums[i];
        }

        int cnt = 0;
        // 每次找mid之间可能的取值范围，相加即可.
        for(int i=0; i<len-1;i++) {
            int left = i;
            int right = len-1;
            // 先找左边界,左边界的右边都会大于presum[left]
            while(left <right  ) {
                int mid = left + (right-left)/2;
                if(presum[mid+1]-presum[left+1] >= presum[left+1]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }

            // 在找右边界，右边界的左边都会小于presum[right]
            int left1 = i;
            int right1 = len-1;
            while(left1 <right1  ) {
                int mid = left1 + (right1-left1)/2;
                if(presum[len]-presum[mid+1] >= presum[mid+1] -presum[left+1] ){
                    left1 = mid+1;
                } else {
                    right1 = mid-1;
                }
            }
            cnt += left1  - left;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1};
        new Solution1().waysToSplit(arr);
    }
}
