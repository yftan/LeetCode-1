package 动态规划.剑指Offer_49_丑数;

public class Solution {
    public int nthUglyNumber(int n) {
        // 动态规划
        int[] dp = new int[n];
        // 初始值
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            // 计算三个值，哪个最小就放在i的位置。然后索引向后移动
            int v1 = 2 * dp[a];
            int v2 = 3 * dp[b];
            int v3 = 5 * dp[c];
            int min = Math.min(v1, Math.min(v2, v3));
            if(min == v1) a++;
            if(min == v2) b++;
            if(min == v3) c++;
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
