package 竞赛.深信服.q5643_将数组分成三个子数组的方案数;

public class Solution {
    // 超时了
    public int waysToSplit(int[] nums) {
        // 双指针法法
        if(nums.length < 3) return 0;
        int len = nums.length;
        int count = 0;
        int start = 0;
        int end = nums.length -1;
        int sumstart = 0;
        int summid = 0;
        int sumend = 0;
        for(int i=0; i < nums.length;i++){
            sumend += nums[i];
        }
        for(int l=0; l< len-2;l++){
            int tmpsum = sumend;
            summid =0;
            sumstart+= nums[l];
            tmpsum -= sumstart;
            for(int r=l+1; r< len-1;r++){
                summid += nums[r];
                tmpsum -= nums[r];
                if(summid >= sumstart && summid <= tmpsum){
                    count++;
                }
            }
        }

        return count;
    }
}
