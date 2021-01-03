package 动态规划.q120_三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯加记忆法
 *
 */
public class Solution1 {
    /*  Error错误： 这个是一个错误的算法，如果是有返回值的，就不要带着sum逐级传，该题实际中memo是从最底层开始计算的，如果传递sum是自上而下的思想了，
    *   递归应该是自下而上。动态规划法才是自上而下的
    *  */
    public int minimumTotal(List<List<Integer>> triangle) {
        //初步回溯法
        int len =triangle.size();
        if(len == 1) return triangle.get(0).get(0);
        // 记录本
        Integer[][] memo = new Integer[len][len];
        return dfs(triangle, 0,0,0, memo);
    }

    public int dfs(List<List<Integer>> triangle, int floor, int pos, int sum, Integer[][] memo ) {
        if(floor >= triangle.size()) {
            return sum;
        }
        if(memo[floor][pos] != null) {
            return memo[floor][pos];
        }
        sum += triangle.get(floor).get(pos);
        int val1 = dfs(triangle, floor+1, pos, sum, memo);
        int val2 = dfs(triangle, floor+1, pos+1, sum, memo);
        memo[floor][pos] = Math.min(val1, val2);
        return  memo[floor][pos];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>(){{add(2);}});
        triangle.add(new ArrayList<Integer>(){{add(3);add(4);}});
        triangle.add(new ArrayList<Integer>(){{add(6);add(5);add(7);}});
        triangle.add(new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}});
        new Solution1().minimumTotal(triangle);
    }

    /* 正确做法 */
    public int minimumTotal1(List<List<Integer>> triangle) {
        //初步回溯法
        int len =triangle.size();
        if(len == 1) return triangle.get(0).get(0);
        // 记录本
        Integer[][] memo = new Integer[len][len];
        return dfs1(triangle, 0,0, memo);
    }

    public int dfs1(List<List<Integer>> triangle, int floor, int pos, Integer[][] memo ) {
        if(floor >= triangle.size()) {
            return 0;
        }
        if(memo[floor][pos] != null) {
            return memo[floor][pos];
        }

        int val1 = dfs1(triangle, floor+1, pos, memo);
        int val2 = dfs1(triangle, floor+1, pos+1, memo);
        memo[floor][pos] = Math.min(val1, val2) + triangle.get(floor).get(pos);
        return  memo[floor][pos] ;
    }
}
