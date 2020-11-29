package Microsoft.q59_螺旋矩阵II;

public class Solution {
    /**
     * 该方法主要是利用colBegin、colEnd、rowBegin、rowEnd每次转圈的值变化进行记录，填写旋转矩阵
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int cur = 1;
        int colBegin = 0;
        int colEnd = n-1;
        int rowBegin = 0;
        int rowEnd = n-1;

        while(cur <= n*n) {
            int i = rowBegin;
            int j = colBegin;
            // left to right
            for( j= colBegin; j <= colEnd; j++) {
                res[rowBegin][j] = cur++;
            }
            rowBegin++;
            for( i= rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = cur++;
            }
            colEnd--;
            for( j=colEnd; j >=colBegin; j--) {
                res[rowEnd][j] = cur++;
            }
            rowEnd--;
            for( i= rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = cur++;
            }
            colBegin++;
        }

        return res;
    }
}
