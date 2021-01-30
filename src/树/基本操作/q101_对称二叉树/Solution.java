package 树.基本操作.q101_对称二叉树;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null) return false;
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
