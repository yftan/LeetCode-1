package 剑指.q67_把字符串转换成整数;

public class Solution {
    public int strToInt(String str) {
        char first = str.charAt(0);
        int len = str.length();
        int flag = 1;
        int carry = 1;
        int i=0, start = -1, j=0;
        while (j<len && str.charAt(j) == ' '){
            j++;
        }
        start = j;
        char ch =str.charAt(j);
        if(ch != '-' && ch != '+' && !isDigital(ch-'0')){
            return 0;
        }
        if (ch == '-') flag = -1;
        while(i<len && !isDigital(first - '0')) {
            first = str.charAt(i++);
        }

        StringBuilder sb= new StringBuilder();
        sb.append(first);
        first=str.charAt(i++);
        while(i <len && isDigital(first-'0')){
            first=str.charAt(i++);
            sb.append(first);
        }

        long res = Long.valueOf(sb.toString().trim());
        if(res*flag > Math.pow(2, 31) -1) {
            return (int)Math.pow(2, 31) -1;
        }
        if( res*flag < Math.pow(2, 31)* -1) {
            return (int) Math.pow(2, 31)* -1;
        }
        return (int)res*flag;

    }

    public boolean isDigital(int num){
        return num  >=0 && num <=9;
    }
    public static void main(String[] args) {
        new Solution().strToInt("-91283472332");
    }
}
