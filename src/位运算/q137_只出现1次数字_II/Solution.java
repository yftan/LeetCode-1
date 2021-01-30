package 位运算.q137_只出现1次数字_II;

public class Solution {
    public int singleNumber(int[] nums) {
        /**
         *  3: 0000 0011
         *
         *  第一次：
         *  two |= （0 & 3） = 0
         *  one ^= 3 = 0000 0011
         *  three = 0000 0000
         *
         *
         */
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = (one & two);
            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }

    public static void main(String[] args) {
        System.out.println(-1 & 2);
//        new Solution().singleNumber(new int[]{3,3,3,2});
    }
}
