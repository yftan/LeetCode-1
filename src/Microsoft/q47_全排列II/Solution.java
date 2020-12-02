package Microsoft.q47_全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    public  static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length < 0 ) return res;
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), used);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> list, boolean[] used){
        if(nums.length == list.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int k=0; k < nums.length;k++){
            if( used[k] == true) continue;
            // 这个地方是回溯剪枝的问题，如果值相同，前一个没有使用，如果你这次使用了，就会和它重复。
            // 这个位置k，注意说的是这个位置的值，要相同值的情况下，要让排在前面的第一个未被使用的使用。
            if( k>0 && nums[k-1] == nums[k] &&  !used[k-1]) continue;
            used[k]=true;
            list.add(nums[k]);
            dfs(nums,list,used);
            used[k]=false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3};
        permuteUnique(nums);
    }
}
