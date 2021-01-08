package 动态规划.股票系列问题.q122_买卖股票的最佳时机_II;

public class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][j],代表的是第i天，状态为j【0代表不持有股票，1持有股票】的时候，最大的现金利润是多少
        // 初始化状态
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 第0天不持有股票，现金利润为0
        dp[0][0] = 0;
        // 第0天持有股票，现金利润为-prices[0]
        dp[0][1] = -prices[0];
        for(int i=1;i < len;i++) {
            // 第i天不持有股票 = max（第i-1天不持有股票， 第i-1天持有股票 + 第i天卖出第利润）；
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 第i天持有股票 = max（第i-1天持有股票， 第i-1天不持有股票 - 第i天买股票的钱）；
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        //因为最后一天不持有股票，利润才会最大化。
        return dp[len-1][0];
    }
}
