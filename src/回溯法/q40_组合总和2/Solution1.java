package 回溯法.q40_组合总和2;

import java.util.*;

public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, 0, target, new LinkedList<Integer>() );
        return res;
    }

    public void backTrace(int[] candidates,int start, int target, LinkedList<Integer> stack){
        if( start > candidates.length) return;
        if(target == 0 && !stack.isEmpty()) {
            List<Integer> list = new ArrayList(stack);
            res.add(list);
        }
        // 如果已经参与计算的数据，并得到返回的结果后，就不要在参与计算了，每个回溯中都维护着这样一个set
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=start; i<candidates.length;i++ ) {
            if(!set.contains(candidates[i]) && target>=candidates[i]){
                stack.push(candidates[i]);
                backTrace(candidates, i+1, target- candidates[i], stack);
                stack.pop();
                set.add(candidates[i]);
            }
        }

    }

    public static void main(String[] args) {
        new Solution1().combinationSum2(new int[]{1, 1, 2, 7, 6, 1, 5}, 8);
    }
}
