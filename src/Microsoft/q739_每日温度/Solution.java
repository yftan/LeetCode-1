package Microsoft.q739_每日温度;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 利用单调栈，栈里面存的是index的值即可
        int len = T.length;
        int[] res = new int[len];
        if( len <=0 ) return res;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        int i=1;
        while(!stack.isEmpty() && i<len){
            while(!stack.isEmpty()  && T[i] > T[stack.peekLast()] ) {
                int cur = stack.pollLast();
                res[cur] = i-cur;
            }
            stack.addLast(i);
            i++;
        }
        return res;
    }
}
