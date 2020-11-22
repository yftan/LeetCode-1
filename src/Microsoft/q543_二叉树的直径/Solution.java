package Microsoft.q543_二叉树的直径;

class Solution {

    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        order(root);
        return max-1;
    }

    public int order(TreeNode root){
        if(root == null) return 0;
        int  leftMax = order(root.left);
        int  rightMax = order(root.right);
        max = Math.max(leftMax + rightMax+1 , max);
        return Math.max(leftMax,rightMax) +1;
    }
}
