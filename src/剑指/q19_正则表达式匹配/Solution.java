package 剑指.q19_正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean isFirst = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1)=='*') {
            return (isMatch(s, p.substring(2)) || (isFirst &&isMatch(s.substring(1), p))) ;
        } else {
            return isFirst && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        new Solution().isMatch("aa", "a*");
    }
}
