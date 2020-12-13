package Microsoft.q767_重构字符串_重点;

/**
 * We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
 * In this way, we can make sure there is always a gap between the same characters
 *
 * Consider this example: "aaabbbcdd", we will construct the string in this way:
 *
 * a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
 * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
 * a b a c a _ b _ b // fill in "c" at position 3
 * a b a c a d b d b // fill in "d" at position 5, 7
 *
 *
 */
public class Solution {
    public String reorganizeString(String S) {
        // 利用数组记录字母出现的次数
        int[] hash = new int[26];
        // 记录最多出现的字母是哪个，以及它的次数
        int letter=0;
        int max=0;
        int len = S.length();
        if(S == null || len <= 0) return "";
        for(int i=0; i< len; i++) {
            char c = S.charAt(i);
            hash[c - 'a']++;
            if( hash[c - 'a'] > max) {
                letter = c - 'a';
                max = hash[c - 'a'] ;
            }
        }
        // 如果最长的字母超过了字符串长度的一半，肯定会挨着。这里的len要加1在除2
        if(max > (len+1)/2) return "";
        // 先把最长的字母放入0、2、4、6..双数的位置
        char[] res = new char[len];
        int index = 0;
        while (hash[letter] >0){
            res[index] = (char)(letter + 'a');
            index += 2;
            hash[letter]--;
        }
        for(int i=0; i < 26; i++) {
            while(hash[i] > 0) {
                // index 只会大于数组长度一次，并且这个地方要是大于等于。"abbabbaaab"如果不是等于就不对。因为len不是数组范围了
                if(index >= len) {
                    index = 1;
                }
                res[index]= (char)(i+'a');
                index +=2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}
