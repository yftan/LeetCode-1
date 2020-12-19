package Microsoft.q139_单词拆分;

import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if(len <= 0) return false;
        // 动态规划法
        // isWord[n]的含义是指从0-n是否存在由wordDict里面的单词组成。分为两种情况：
        // 1. 0-n之间没有其它单词，所以只需判断s.substring(0,n+1)是否是wordDict单词即可
        // 2. 0-n之间存在其它单词，那么就依次遍历当isWord[j] == true的时候证明前面的单词（一个或多个）都是可以在wordDict查到的。
        //    只需判断j-n之间是否是单词即可
        boolean[] isWord = new boolean[len];
        for(int i=0; i < len; i++) {
            for(int j=0; j <= i;j++) {
                if(j== i) {
                    if(wordDict.contains(s.substring(0,i+1))){
                        isWord[i] = true;
                    }
                    continue;
                }
                if(isWord[j] == true) {
                    if(wordDict.contains(s.substring(j+1,i+1))){
                        isWord[i] = true;
                        continue;
                    }
                }
            }
        }
        return isWord[len-1];
    }
}
