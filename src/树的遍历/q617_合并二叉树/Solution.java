package 树的遍历.q617_合并二叉树;

/**
 * 重要，好好理解两种方式
 *
 */
public class Solution {
    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees_1(TreeNode t1, TreeNode t2) {
        /**
         * 自己最开始写错了 ，不应该new一个新的，因为后面还有值，是不会参与计算了。
         * 正确的是还要使用原来t2，虽然不会继续下去了，但是它是指针，后面的数据还会保留
         *         if(t1 ==null && t2 == null) return null;
         *         if(t1 != null && t2 == null) return t1;
         *         if(t1 == null && t2!=null) {
         *             return new TreeNode(t2.val);
         *         }
         *
         */
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 不修改原二叉树的解法
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        // 先合并根节点
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        // 再递归合并左右子树
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        TreeNode root1 = new TreeNode(3);
        TreeNode n11 = new TreeNode(9);
        TreeNode n21 = new TreeNode(20);
        TreeNode n31 = new TreeNode(15);
        TreeNode n41 = new TreeNode(7);
        root1.left = n11;
        root1.right = n21;
        n21.left = n31;
        n21.right = n41;

        new Solution().mergeTrees(root, root1);
    }

}


