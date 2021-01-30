package 树.基本操作.q236_二叉树的最近公共祖先;

/**
 * LCA二叉树的最近公共祖先（递归）o(n)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树有，右子树没有，证明都在左子树。
        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            // 如果左子树没有，右子树有，证明都在右子树。
            return right;
        } else if (left == null && right == null) {
            // 如果左子树没有，右子树没有，则返回null。
            return null;
        } else {
            // 如果左子树，右子树都有，则返回root
            return root;
        }
        // if (left != null && right == null) {
        //     //左子树上能找到，但是右子树上找不到，此时就应当直接返回左子树的查找结果
        //     return left;
        // } else if (left == null) {
        //     //右子树上能找到，但是左子树上找不到，此时就应当直接返回右子树的查找结果
        //     return right;
        // }
        // //左右子树上均能找到，说明此时的p结点和q结点分居root结点两侧，此时就应当直接返回root结点
        // return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right == null) {
            return left;
        } else if(right!= null && left == null){
            return right;
        } else if(left == null && right == null) {
            return null;
        } else{
            return root;
        }
    }
}
