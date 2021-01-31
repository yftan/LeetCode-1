package 竞赛.深信服.ThoughtWorks.q5243_同积元组;

class Solution {
    int res =0;
    public int tupleSameProduct(int[] nums) {
        for(int i=0; i < nums.length; i++) {
            dfs(nums, i, 0, new int[4], new boolean[nums.length]);
        }
        return res;
    }
    public void dfs(int[] nums, int idx, int count, int[] item , boolean[] isVisited){
        if(count <0 ) return;
        isVisited[idx] = true;
        item[count] = nums[idx];
        if(count == 3){
            if(item[0] !=0 && item[0]*item[1] == item[2]*item[3]){
                res++;
            }
            return;
        }
        for(int i=0; i < nums.length;i++) {
            if(isVisited[i]) continue;
            count++;
            dfs(nums, i,count, item, isVisited);
            isVisited[i] = false;
            count--;
        }
    }

    public static void main(String[] args) {
        new Solution().tupleSameProduct(new int[]{2,3,4,6});
    }
}
