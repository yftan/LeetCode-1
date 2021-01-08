package 回溯法.q113_路径和_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 回溯法
        dfs(root, new ArrayList(), 0, sum);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> item, int sub, int sum){
        if(root == null) return;
        int val =root.val + sub;
        // 当值相等的时候，因为可能不是叶子节点，所以需要进行判断
        if(val == sum) {
            if( root.left == null && root.right == null) {
                //这个地方可能比较绕一点，因为是提前一步判断的，如果存在就加到list里，因为存在回溯，这个地方要手动回溯
                item.add(root.val);
                res.add(new ArrayList(item));
                item.remove(item.size()-1);
                return;
            }
            // 这里不能直接返回是因为存在[1,-2,-3,1,3,-2,null,-1]这种情况，所以还要继续向下计算
        }
        // 首先加入根节点
        item.add(root.val);
        sub += root.val;
        dfs(root.left, item, sub, sum);
        dfs(root.right, item, sub, sum);
        // 回溯
        sub -= root.val;
        item.remove(item.size()-1);
    }
}
