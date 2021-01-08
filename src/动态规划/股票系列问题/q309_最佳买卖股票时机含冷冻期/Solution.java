package 动态规划.股票系列问题.q309_最佳买卖股票时机含冷冻期;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0) return 0;
        int len = prices.length;
        // dp[i][j]表示第i天，状态j【0代表不持股不在冷冻期，1代表不持股在冷冻期，2代表持股不在冷冻期】
        int[][] dp = new int[len][3];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = -prices[0];
        for(int i=1; i< len; i++) {
            // 第i天第不持股不在冷冻期 = max（第i-1天不持股不在冷冻期，第i-1天不持股在冷冻期）
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] );
            // 第i天不持股在冷冻期 = 第i-1天持股并卖掉prices[i](只有一种可能转移过来)
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + prices[i]);
            // 第i天持股不在冷冻期 = max（第i-1天持股不在冷冻期，第i-1天不持股此次购入 ）
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] - prices[i]);
        }
        return Math.max(Math.max(dp[len-1][0], dp[len-1][1]), 0);
    }
}
