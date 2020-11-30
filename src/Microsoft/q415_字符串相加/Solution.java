package Microsoft.q415_字符串相加;

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int len1 = num1.length();
        int len2 = num2.length();
        int carry =0;
        for(int i=len1-1,j=len2-1; i>=0 || j >=0;i--,j--) {
            int x=0,y=0;
            if(i>=0) {
                x = num1.charAt(i) - '0';
            }
            if(j >=0) {
                y = num2.charAt(j) - '0';
            }
            sb.append((x+y+carry)%10);
            carry = (x+y+ carry)/10;
        }

        if(carry!=0) {
            sb.append(carry);
        }

        //  因为循环是从最后一位往前，sb的追加是加到最后。所以最后要翻转一下
        return sb.reverse().toString();
    }
}
