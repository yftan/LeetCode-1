package 回溯法.q60_全排列;

/**
 * 全排列：一般考虑的方向就是DFS加减枝
 *
 *
 *
 */
class Solution {
    int count = 0;
    String res;
    public String getPermutation(int n, int k) {
        dfs(new StringBuilder(), n, k , new int[n+1]);
        return res;
    }

    public void dfs(StringBuilder sb ,int n, int k , int[] memo ){
        if(sb.length() == n){
            if(++count == k) {
                res = sb.toString();
            }
            return ;
        }
        // 注意一点，回溯法的添加和回退操作，要在循环里面完成
        // 如果找到了字符串就直接结束即可
        for(int i=1; i<=n;i++){
            if(memo[i] == 0 && (res==null || res.length()<=0 )) {
                memo[i] =1;
                sb.append(String.valueOf(i));
                dfs(sb, n,k,memo);
                sb.deleteCharAt(sb.length()-1);
                memo[i] =0;
            }
        }
    }
}
