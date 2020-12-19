package Microsoft.q459_重复的子字符串;

public class Solution {
    /**
     *  暴力解法
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 0 ||len == 1 ) return false;
        // every time choose one char append the sb
        for(int i=0; i < len-1; i++) {
            StringBuilder sb = new StringBuilder();
            String tmp = s.substring(0,i+1);
            while(sb.length() < len) {
                sb.append(tmp);
            }
            if(sb.toString().equals(s)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * 解题思路
     * 如果您的字符串 S 包含一个重复的子字符串，那么这意味着您可以多次 “移位和换行”`您的字符串，并使其与原始字符串匹配。
     *
     * 例如：abcabc
     *
     * 移位一次：cabcab
     * 移位两次：bcabca
     * 移位三次：abcabc
     *
     * 现在字符串和原字符串匹配了，所以可以得出结论存在重复的子串。
     *
     * 基于这个思想，可以每次移动k个字符，直到匹配移动 length - 1 次。但是这样对于重复字符串很长的字符串，效率会非常低。在 LeetCode 中执行时间超时了。
     *
     * 为了避免这种无用的环绕，可以创建一个新的字符串 str，它等于原来的字符串 S 再加上 S 自身，这样其实就包含了所有移动的字符串。
     *
     * 比如字符串：S = acd，那么 str = S + S = acdacd
     *
     * acd 移动的可能：dac、cda。其实都包含在了 str 中了。就像一个滑动窗口。因为(dac)、(cda)是acd的所有旋转可能，如果不存在相同的，那么就没有了
     *
     * 一开始 acd (acd) ，移动一次 ac(dac)d，移动两次 a(cda)cd。循环结束。
     *
     * 所以可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
     *
     *
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern1(String s) {
        String str = s +s ;
        return str.substring(1, str.length() -1).contains(s);
    }

}
