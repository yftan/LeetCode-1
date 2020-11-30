package Microsoft.q151_翻转字符串里的单词;

import java.util.LinkedList;

class Solution {
    /**
     * 该方法借助了LinkedList可以前插的特点
     *
     * TODO：利用先翻转整个字符串，在翻转单个word，然后在去除空格的思路
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        LinkedList<String> res = new LinkedList<String>();
        int len = s.length();
        int i=0,j=0;
        while(i<len) {
            while(i<len && s.charAt(i) == ' '){
                i++;
            }
            j=i;
            while(j<len) {
                while( j< len && s.charAt(j) !=' ' ){
                    j++;
                }
                if(j< len &&  s.charAt(j) ==' ') break;
            }
            if(s.substring(i,j).length() > 0 && !" ".equals(s.substring(i,j))){
                res.addFirst(s.substring(i,j));
            }
            i=j+1;
        }
        StringBuffer sb = new StringBuffer();
        while(!res.isEmpty()){
            sb.append(res.removeFirst());
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}
