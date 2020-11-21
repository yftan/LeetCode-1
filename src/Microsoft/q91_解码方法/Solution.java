package Microsoft.q91_解码方法;

public class Solution {

    /**
     * 动态规划法，方法一，不好理解memo[n] =1
     */
    public int numDecodings(String s) {
        // 01背包问题是从后往前
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public int numDecodings1(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '0' ? 0: 1;
        for( int i=1; i < len; i++){
            int first = Integer.valueOf(s.substring(i,i+1));
            int second = Integer.valueOf(s.substring(i-1,i+1));
            if(first >=1 && first<=9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                // 重点在这句，当i<2的时候，dp[1]前面没有值，在有效数字当前提下，它初始是1。
                dp[i] += i>=2 ? dp[i-2] : 1;
            }
        }
        return dp[len-1];
    }
}
