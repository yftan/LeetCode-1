package Microsoft.q121_买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=1; i < prices.length; i++) {
            for(int j=0; j <i ; j++) {
                if(prices[i] - prices[j] > max) {
                    max = prices[i] - prices[j];
                }
            }
        }
        return max;
    }

    /**
     * 动态规划法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if(null == prices || prices.length == 0 ) return 0;
        int max = 0;
        int min = prices[0];
        for(int i=1; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min );
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
