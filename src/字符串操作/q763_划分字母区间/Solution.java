package 字符串操作.q763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 先存储每个字母最后出现的位置，最后遍历一次 o(n)
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public List<Integer> partitionLabels1(String S) {
        int[] endc = new int[26];
        // endc 记录字母最后出现当位置
        for(int i=0;i < S.length();i++) {
            endc[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        // 利用双指针方法
        int start=0, end =0;
        for(int i=0;i < S.length();i++) {
            // 由于end是在循环外的，所以一次赋值后，必须要等到超过end，它才会更新。
            // 如果i正好和end相等，证明索引在start～i区间，重复的字母索引最大也没有大过end。
            end = Math.max(end,  endc[S.charAt(i) - 'a'] );
            if(end == i) {
                res.add(end-start+1);
                start = end +1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().partitionLabels("abccaddbeffe");
    }
}
