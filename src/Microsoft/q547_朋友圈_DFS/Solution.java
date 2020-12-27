package Microsoft.q547_朋友圈_DFS;

public class Solution {
    // 记录改同学是否被访问
    boolean[] isVisited;
    int res =0;
    public int findCircleNum(int[][] M) {
        int len = M.length;
        isVisited = new boolean[len];
        for(int i=0; i < len;i++){
            if(!isVisited[i]){
                // 这个地方每次进去，都会遍历出一个朋友圈。或是自己独立的一个朋友圈，所以res++
                dfs(M, i);
                res++;
            }
        }
        return res;
    }

    // 遍历i的所有朋友，遍历到就标记已经访问即可
    public void dfs(int[][] M,int i){
        for(int j=0; j< M.length;j++){
            if(M[i][j] == 1 && !isVisited[j]){
                isVisited[j] = true;
                dfs(M, j);
            }
        }
    }
}
