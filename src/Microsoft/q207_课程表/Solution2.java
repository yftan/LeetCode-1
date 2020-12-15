package Microsoft.q207_课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 根据自己的理解重新写的一份
 *
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 本次使用的方式是广度优先遍历，一般都是要借助队列Queue完成。
        // 由于课程直接有依赖关系[0,1],证明课程0依赖课程1。那么通过邻接表记录1->0->...所依赖的课程
        // 通过indegrees记录每个课程所依赖其它课程的数量，即入度。
        // 将不需要依赖其它课程的课程先入Queue，然后逐个取出遍历它的宽度即距离为1的课程，然后将indegrees[cur]--，
        // 如果indegrees[cur]=0,证明它也不需要依赖其它的课程，即入队列。
        // 那么遍历完整个图之后，numCourses==0，证明所有课程都可以正常依赖，否则返回false
        List<List<Integer>> adjcent = new ArrayList<>();
        // 初始化链接表
        for(int i=0; i< numCourses;i++) {
            adjcent.add(new ArrayList());
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        for(int[] c : prerequisites){
            indegrees[c[0]]++;
            adjcent.get(c[1]).add(c[0]);
        }
        for(int i=0; i < numCourses; i++ ){
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for( int cur : adjcent.get(pre)) {
                if(--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
