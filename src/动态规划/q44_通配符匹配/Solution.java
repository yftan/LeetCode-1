package 动态规划.q44_通配符匹配;

class Solution {
    public boolean isMatch(String s, String p) {
        // 动态规划
        int m = s.length();
        int n = p.length();

        // 加1的原因是考虑空串的情况，方便后面计算
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // 初始化变量，这个初始化考虑的是当m为空串的时候，dp的状态
        // 因为s是空串，只要p为*就为ture。""，"****"考虑这样情况。初始状态要设置对
        for(int j=1; j<=n;j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=m;i++) {
            for(int j=1;j<=n;j++){
                //第一种情况就是是字母或？的时候，这两种情况一样
                if( p.charAt(j-1) != '*' ) {
                    if( s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?' ){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    //第二种情况等于*时，也分两种情况，
                    //一种是匹配空串：那就要判断s[i]是否与p[j-1]相等
                    //一种是匹配多次：那就要判断s[i-1]是否与p[j]相等
                } else {
                    dp[i][j] =  dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new Solution().isMatch("aaa", "*");
    }
}

