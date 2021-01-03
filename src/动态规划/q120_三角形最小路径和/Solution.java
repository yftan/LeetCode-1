package 动态规划.q120_三角形最小路径和;

import java.util.List;

/**
 * 回溯法超时
 */
public class Solution {
    int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        //初步回溯法
        int len =triangle.size();
        if(len == 1) return triangle.get(0).get(0);
        dfs(triangle, 0,0,0);
        return min;
    }

    public void dfs(List<List<Integer>> triangle, int floor, int pos, int sum) {
        if(floor >= triangle.size()) {
            min = Math.min(sum, min);
            return;
        }
        int floorCount = triangle.get(floor).size();
        sum += triangle.get(floor).get(pos);
        dfs(triangle, floor+1, pos, sum);
        dfs(triangle, floor+1, pos+1, sum);
    }
}
