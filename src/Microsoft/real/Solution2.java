package Microsoft.real;

public class Solution2 {
    public static void main(String[] args) {
        //6
        String S = "0110";
        int res = 0;
        int pos = S.indexOf("1");
//        if(pos == -1) return 0;
        if(pos != 0) {
            S = S.substring(pos);
        }
        for (int i = S.length()-1; i >= 1 ; i--) {
            if(S.charAt(i) == '0'){
                res++;
            } else {
                res += 2;
            }
        }
        System.out.println(res+1);
    }
}
