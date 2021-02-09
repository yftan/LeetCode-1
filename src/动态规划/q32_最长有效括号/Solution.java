package 动态规划.q32_最长有效括号;

public class Solution {
    public int longestValidParentheses(String s) {
        if("".equals(s)) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max =  0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = (i>= 2? dp[i-2]:0 ) + 2;
                } else if(i-dp[i-1] >0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i-1] + 2 + ( i - dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
