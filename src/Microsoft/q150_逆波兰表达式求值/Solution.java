package Microsoft.q150_逆波兰表达式求值;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length <=0) return 0;
        // 利用栈的特性
        Deque<String> stack = new LinkedList<>();

        for(int i=0; i< tokens.length; i++) {
            if("+".equals(tokens[i]) ||"-".equals(tokens[i]) ||"*".equals(tokens[i]) || "/".equals(tokens[i]) ){
                String b = stack.pollLast();
                String a = stack.pollLast();
                int res = calculate(a, b, tokens[i]);
                stack.addLast(String.valueOf(res));
            } else {
                stack.add(tokens[i]);
            }
        }
        return Integer.valueOf(stack.peekLast());
    }

    public int calculate(String a, String b, String opt){
        int numa = Integer.valueOf(a);
        int numb = Integer.valueOf(b);
        if("+".equals(opt)) {
            return numa + numb;
        } else if("-".equals(opt)){
            return numa - numb;
        } else if("*".equals(opt)){
            return numa * numb;
        } else if("/".equals(opt)){
            return numa / numb;
        }
        return 0;
    }
}
