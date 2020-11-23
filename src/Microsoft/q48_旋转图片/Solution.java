package Microsoft.q48_旋转图片;

class Solution {

    /**
     * 该方法就是图片的旋转，一层一层向内计算。建议画4x4的图进行推送
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<matrix.length/2;i++){
            for(int j =i;j<n-i-1;j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    /**
     * 方法二：向进行斜轴对称变化，在进行中间对称变化，很精妙
     *
     * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
     *
     * 1  2  3
     * 4  5  6
     * 7  8  9
     * after transpose, it will be swap(matrix[i][j], matrix[j][i])
     *
     * 1  4  7
     * 2  5  8
     * 3  6  9
     * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
     *
     * 7  4  1
     * 8  5  2
     * 9  6  3
     *
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}