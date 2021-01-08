package 动态规划.股票系列问题.q123_买卖股票的最佳时机_III;

public class Solution {
    /**
     * 三维数组
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][3][2];

        // 第二维为0的时候没有意义，所以都是0。
        // dp[i][j][k]代表，第i天，第j次交易，状态为k【0代表不持有，1代表持有】的最大收益。
        // 这里有个非常难以理解的地方，就是只有卖出才会计数，不要想成买入卖出都计数
        dp[0][0][0] = 0;
        // 没有卖出，买入了
        dp[0][0][1] = -prices[0];
        // 买入了，又卖出了
        dp[0][1][0] = 0;
        // 第一次买入了，然后卖出；在买入，现在在持有
        dp[0][1][1] = -prices[0];
        // 两次买入与卖出
        dp[0][2][0] = 0;
        // 两次买入与卖出，已经到达限额了,不可能持有的，是个不存在的值。
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            // 第一次交易导致的持有 = max（前一天买入就持有了，前一天没有买入今天买入）
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            // 第一次交易导致的不持有 = max（前一天就卖出不持有了，前一天持有这次卖出了）
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            // 第二次交易导致的持有 = max（前一天第二次买入并持有，前一天第一次卖出后在一次买入）
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            // 第二次交易导致的不持有 = max（前一天第二次卖出不持有，前一天第二次买入并在今天卖出）
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }

        //返回最大值,这个地方为怀疑是可能考虑存在负数的情况
        int a = Math.max(dp[len - 1][0][0], dp[len - 1][0][1]);
        int b = Math.max(dp[len - 1][1][0], dp[len - 1][1][1]);

        return Math.max(Math.max(a, b), dp[len - 1][2][0]);
    }

    /**
     * 压缩到二位数组
     * <p>
     * 这我们定义一个二维数组 dp[n][5]
     * 这的n表示天数，5表示5种不同的状态
     * <p>
     * 其实这个转换跟 三维数组的有点类似，在三维数组中我们定义了交易次数、买卖状态。
     * 因为交易次数和买卖状态都是常数个，所以我们把这两者整合到一起了。
     */
    public int maxProfit1(int[] prices) {
        if (prices == null && prices.length <= 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][5];
        // 第一天，没有买入
        dp[0][0] = 0;
        // 第一天，第一次买入
        dp[0][1] = -prices[0];
        // 第一天，第一次卖出
        dp[0][2] = 0;
        // 第一天，第二次买入
        dp[0][3] = -prices[0];
        // 第一天，第二次卖出
        dp[0][4] = 0;
        for(int i=1; i < len;i++) {
            // 第i天，没有买入。这个只能由i-1转移过来，值都为0，可以省略。
            dp[i][0] = dp[i-1][0];
            // 第i天，第一次买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            // 第i天，第一次卖出
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            // 第i天，第二次买入
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            // 第i天，第二次卖出
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        return dp[len-1][4];
    }
}
