package 剑指.q13_机器人的运动范围;

public class Solution {
    public int movingCount(int m, int n, int k) {
        int count =0;
        if ( m==0 || n==0) return 0;
        int[][] dp =new int[m][n];
        dp[0][0] =  k==0? 0:1;
        count++;
        for(int i=0; i <m ;i++) {
            for(int j=0;j<n;j++) {
                if( ( i-1 >=0 && dp[i-1][j] == 1) ||
                        ( i+1 < m && dp[i+1][j] == 1) ||
                        ( j-1 >=0 && dp[i][j-1] == 1) ||
                        ( j+1 <n  && dp[i][j+1] == 1 )){
                    if(sum(i,j) <= k) {
                        dp[i][j] = 1;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int sum(int i, int j) {
        int res = 0;
        while( i/10 != 0) {
            res += i/10;
            i=i%10;
        }
        res += i;
        while( j/10 != 0) {
            res += j/10;
            j=j%10;
        }
        res += j;
        return res;
    }

    public static void main(String[] args) {
        new Solution().movingCount(1,2,1);
    }
}
