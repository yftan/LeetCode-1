package Microsoft.q207_课程表;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 方法一：利用邻接图+BFS方法
        List<List<Integer>> adjcent = new ArrayList<>();
        // 初始化邻接表
        for(int i=0; i< numCourses;i++) {
            adjcent.add(new ArrayList());
        }
        // 将数据放入邻接表中
        for(int i=0; i< prerequisites.length; i++) {
            int m = prerequisites[i][0];
            int n = prerequisites[i][1];
            adjcent.get(m).add(n);
        }

        // 作为访问标识，index代表具体课程
        // 0 代表该课程未访问，
        // 1代表本次bfs已经访问过了，
        // 2代表在其它的bfs已经访问过了，因为这个搜索的是前置条件，所以返回true。因为在其它bfs已经学过了
        int[] isFlag = new int[numCourses];
        // 利用bfs方法遍历邻接图，判断是否存在环。
        // 注意这个地方是循环
        for(int i=0; i< numCourses; i++) {
            if(!bfs(adjcent, isFlag,i)) return false;
        }
        return true;
    }

    // i 代表正在遍历的课程
    public boolean bfs( List<List<Integer>> adjcent, int[] flag, int i){
        if(flag[i] == 1) return false;
        if(flag[i] == 2) return true;
        flag[i] =1;
        for(Integer j : adjcent.get(i)){
            if(!bfs(adjcent, flag , j)) return false;
        }
        flag[i] =2;
        return true;
    }
}
