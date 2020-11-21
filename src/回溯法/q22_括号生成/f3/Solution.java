package 回溯法.q22_括号生成.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法 o((4^n)/(n^1/2))
 */
public class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String cur = "";
        generate(n,0,0,cur);
        return res;
    }
    public void generate(int n,int left, int right, String cur){
        if(left ==n && right==n){
            res.add(cur);
            return;
        }
        if(left <n){
            generate(n, left+1, right, cur+"(");
        }
        if(right < left && right <n){
            generate(n, left, right+1, cur+")");
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
