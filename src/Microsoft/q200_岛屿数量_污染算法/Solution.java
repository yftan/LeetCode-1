package Microsoft.q200_岛屿数量_污染算法;

class Solution {
    public int numIslands(char[][] grid) {
        int nums =0;
        int ilen = grid.length;
        int jlen = grid[0].length;
        for(int i=0; i< ilen; i++) {
            for(int j=0; j < jlen; j++) {
                // 如果出现1，岛屿数量就+1。然后利用污染算法，将相连的值都进行改变即可。
                // 也可以新建一个visied[][]对象，存储是否被访问过。就不会污染原有数组
                if(grid[i][j] == '1') {
                    infect(grid, i, j);
                    nums++;
                }
            }
        }
        return nums;
    }

    public void infect(char[][] grid, int i, int j) {
        // 限定条件要注意，>=符号，以及最后的!=1的都直接返回即可
        if(i < 0 || j < 0 || i>= grid.length || j >= grid[0].length  || grid[i][j] != '1') return;
        // 如果相连都值为1，那么将它改为2，或其它非1都值都可以。
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
        }

        infect(grid, i-1, j);
        infect(grid, i+1, j);
        infect(grid, i, j-1);
        infect(grid, i, j+1);
    }
}
