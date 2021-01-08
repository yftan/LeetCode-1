package 动态规划.股票系列问题.q714_买卖股票的最佳时机含手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <=0 ) return 0;
        int len = prices.length;
        // dp[i][j]代表第i天，状态j【0表示不持有，1表示持有】的最大利润
        int[][] dp = new int[len][2];
        // 初始状态，没有交易
        dp[0][0] = 0;
        // 第一天持有，没有卖所以先不用扣税
        dp[0][1] = -prices[0];

        for(int i=1; i< len;i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            // 只有等到卖出在扣税
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] +prices[i] -fee );
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);

    }
}
