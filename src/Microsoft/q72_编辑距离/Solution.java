package Microsoft.q72_编辑距离;

/**
 * 递归方法，利用了记事本原理
 */
class Solution {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n =word2.length();
        memo = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            memo[i][0]=i;
        }
        for(int j=1;j<=n;j++){
            memo[0][j]=j;
        }

        return minDis(word1, word2);
    }

    public int minDis(String w1, String w2){
        if(w1.length() == 0 ) return w2.length();
        if(w2.length() == 0 ) return w1.length();

        if(memo[w1.length()][w2.length()] !=0) return memo[w1.length()][w2.length()];

        if(w1.charAt(w1.length()-1) == w2.charAt(w2.length()-1)){
            memo[w1.length()-1][w2.length()-1]  = minDis(w1.substring(0, w1.length()-1), w2.substring(0, w2.length()-1));
            return memo[w1.length()-1][w2.length()-1] ;
        }

        // 主要是这个地方的理解，三种情况,
        // 1、插入：假如插入最后w1= aed, w2=de。在w1后插入e.实际比较都就是w1= aed与 w2=d
        // 2、删除：假如删除最后w1= aed, w2=de。在w1后删除最后一位，实际上比较都是w1= ae与 w2=de
        // 3、修改：假如修改最后w1= aed, w2=de。在w1后修改为e,实际上比较都是w1= ae 与 w2=d
        // 为什么都是假设最后一位，因为我们用都是递归方法，第一次计算都时候都是从最小位开始计算的，所以一个一个字母从前到后考虑
        // 所以也可以使用动态规划法进行计算
        memo[w1.length()][w2.length()] = 1+ minThree(
                minDis(w1, w2.substring(0, w2.length()-1)),
                minDis(w1.substring(0, w1.length()-1), w2),
                minDis(w1.substring(0, w1.length()-1), w2.substring(0, w2.length()-1) )
        );
        return memo[w1.length()][w2.length()];
    }

    public int minThree(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
}