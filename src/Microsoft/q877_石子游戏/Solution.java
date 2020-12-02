package Microsoft.q877_石子游戏;

public class Solution {
    /**
     * 该方法使用了双指针，每次大的都给A，小的都给L，最后判断即可
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        if( piles ==null || piles.length <0  ) return false;
        int len = piles.length;
        int start =0;
        int end = len-1;
        int aSum = 0;
        int lSum = 0;
        while (start < end) {
            if(piles[start] > piles[end]) {
                aSum += piles[start++];
                lSum += piles[end--];
            } else {
                aSum += piles[end--];
                lSum += piles[start++];
            }
        }
        if(aSum > lSum) {
            return true;
        } else {
            return false;
        }
    }
}
