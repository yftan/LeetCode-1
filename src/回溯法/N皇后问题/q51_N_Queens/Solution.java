package 回溯法.N皇后问题.q51_N_Queens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 该方法使用了深度优先遍历的方式，把行当成了深度
     *
     */
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        String[][] martix = new String[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j <n; j++) {
                martix[i][j] = ".";
            }
        }
        dfs(martix, 0);
        return res;
    }

    /**
     * 以每行进行向下搜索，当row == martix.length结束，索引是从0开始当
     *
     * @param martix
     * @param row
     */
    public void dfs(String[][] martix, int row){
        if(row == martix.length) {
            print(martix);
            return;
        }

        for(int j=0; j<martix[0].length; j++ ){
            if(isValid(martix, row, j)){
                martix[row][j] = "Q";
                dfs(martix, row +1);
                martix[row][j] = ".";
            }
        }
    }

    public boolean isValid(String[][] martix, int row , int col){
        // 因为是逐行放的，只需检查该坐标的正上方是否有棋子
        for(int i=0; i< row;i++){
            if("Q".equals(martix[i][col])) {
                return false;
            }
        }
        // 因为是从上往下，逐行放的，所以只需检查左上方与右上方是否存在
        // 检查左上方
        for(int i=row-1, j=col-1; i>=0 && j >=0 ;i--,j--){
            if("Q".equals(martix[i][j])) {
                return false;
            }
        }
        // 检查右上方，这里注意j是col+1
        for(int i=row-1, j=col+1; i>=0 && j < martix[0].length ;i--,j++){
            if("Q".equals(martix[i][j])) {
                return false;
            }
        }
        return true;
    }

    public void print(String[][] martix) {
        List<String> item = new ArrayList();
        int n =martix.length;
        for(int p=0; p< n; p++) {
            StringBuilder sb = new StringBuilder();
            for(int q=0; q <n; q++) {
                sb.append(martix[p][q]);
            }
            item.add(sb.toString());
        }
        res.add(item);
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}