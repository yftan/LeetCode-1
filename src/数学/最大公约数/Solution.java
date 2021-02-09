package 数学.最大公约数;

public class Solution {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().gcd(6, 12));
    }
}
