package 前缀和.q848_字母移位;

public class Solution {

    /**
     *
     * 利用后缀和，时间复杂度O(N)
     *
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters(String S, int[] shifts) {
        int len = shifts.length;
        if (len <= 0) return S;
        if( S.length() == 0 ) return S;

        int[] shiftsTmp = new int[len];
        // 1，首先计算前缀和，然后在进行旋转
        shiftsTmp[len-1] = shifts[len-1];
        for(int i=len-2; i>= 0; i--) {
            shiftsTmp[i] += shiftsTmp[i+1]%26 + shifts[i]%26;
        }

        // 由于shifts[i]范围太大，所以取余%26
        StringBuilder sb = new StringBuilder(S);
        for(int i=0; i<len; i++){
            int val = (int)sb.charAt(i) + shiftsTmp[i]%26;
            if(val > 97+25){
                val = val -26;
            }
            sb.setCharAt(i, (char)(val));
        }
        return sb.toString();
    }

    /**
     * 暴力解法超时
     *
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters1(String S, int[] shifts) {
        // 由于shifts[i]范围太大，所以取余%26
        int len = shifts.length;
        if (len <= 0) return S;
        if( S.length() == 0 ) return S;
        StringBuilder sb = new StringBuilder(S);
        for(int i=0; i<len; i++){
            for(int j=0; j<=i;j++) {
                int val = (int)sb.charAt(j) + shifts[i]%26;
                if(val > 97+25){
                    val = val -26;
                }
                sb.setCharAt(j, (char)(val));
            }
        }
        return sb.toString();
    }
}
