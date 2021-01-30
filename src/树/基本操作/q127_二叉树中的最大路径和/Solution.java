package 树.基本操作.q127_二叉树中的最大路径和;

public class Solution {
    int max =0;
    public int maxPathSum(TreeNode root) {
        order(root);
        return max;
    }
    public Integer order(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, order(root.left));
        int right = Math.max(0, order(root.right));
        max = Math.max(max, left+ right +  root.val );
        return Math.max(left, right) + root.val;
    }
}
