package Microsoft.q695_岛屿面积;

/**
 * TODO：还有一道类似的hard题，可以在leetcode评论中找
 *
 */
class Solution {
    int m ,n;
    int sum;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        m=grid.length;
        n=grid[0].length;
        for(int i=0; i< m;i++) {
            for(int j=0; j <n;j++) {
                if(grid[i][j] == 1) {
                    sum=0;
                    area(grid,i,j);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }


    /**
     * 自己写的方法，没有用int返回，可以参考Solution1。很精妙
     * @param grid
     * @param i
     * @param j
     */
    public void area(int[][] grid, int i, int j){
        if(i<0 || j <0 || i>=m || j >=n || grid[i][j]!=1) return ;
        if(grid[i][j] == 1) {
            sum += 1;
            grid[i][j] = 2;
        }

        area(grid, i-1, j);
        area(grid, i+1, j);
        area(grid, i, j-1);
        area(grid, i, j+1);
    }
}