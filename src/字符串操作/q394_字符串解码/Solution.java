package 字符串操作.q394_字符串解码;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 完全错误的解答
 */
class Solution {
    public String decodeString(String s) {
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<Character> stackStr = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 记录左括号的个数
        int leftCount = 0;

        StringBuilder tmp = new StringBuilder();
        int multi = 0;
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(isNum(c)) {
                multi = multi * 10 + Integer.parseInt(c + "");
                if(s.charAt(i+1) == '[') {
                    stackNum.addLast(multi);
                    multi =0;
                }
            } else {
                if(stackNum.isEmpty()){
                    sb.append(c);
                } else if(c != ']') {
                    if(c == '[') leftCount++;
                    stackStr.addLast(c);
                } else {
                    int count = stackNum.pollLast();
                    while('[' !=stackStr.peekLast()){
                        char a = stackStr.pollLast();
                        // 采用前插
                        tmp.insert(0,a);
                    }
                    // 删除左括号
                    stackStr.pollLast();
                    leftCount--;
                    String t = tmp.toString();
                    for( int j=0;j<count-1;j++){
                        tmp.append(t);
                    }
                    if(leftCount == 0){
                        sb.append(tmp);
                        tmp.delete(0, tmp.capacity());
                    }
                }
            }
        }

        return sb.toString();

    }

    public boolean isNum(char c){
        if(c >= '0' && c <='9') return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}