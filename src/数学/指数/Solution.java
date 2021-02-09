package 数学.指数;

public class Solution {

    // 计算 a ^ b
    public double myPow(double x, int n) {
        double ans = 1.0;
        long b  = n;
        if( b < 0 ) {
            x = 1/x;
            b= -b;
        }
        while(b >0) {
            if((b&1)==1) ans *= x;
            // 分治的思想
            x *=x;
            b>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 8));
    }
}
