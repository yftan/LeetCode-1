package Microsoft.q450_删除二叉搜索树中的节点;

/**
 * 二叉搜索树的特点就是中序遍历是有序的数组
 *
 * 所以某节点node的中序：
 * 前缀节点为node.left.right...right，直到最后一个不能null的节点为止
 * 后继节点为node,right.left...，直到最后一个不能null的节点为止
 *
 * 1、删除某节点，如果是叶子节点则直接删除即可。
 * 2、如果root.left不为null，证明它存在前缀节点，替换node的值，然后在deleteNode(root.left, key)，key为前缀节点的值
 * 3、如果root.right不为null，证明它存在后缀节点，替换node的值，然后在deleteNode(root.right, key)，key为后缀节点的值
 *
 * 继续递归是为了删除替换后的重复节点
 *
 *
 */
public class Solution {
    /**
     计算前驱节点的值
     **/
    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right!=null) {
            root = root.right;
        }
        return root.val;
    }

    /**
     计算后继节点的值
     **/
    public int successor(TreeNode root){
        root = root.right;
        while(root.left!= null) {
            root = root.left;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if( root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left==null && root.right ==null) {
                root = null;
            } else if(null != root.left){
                root.val = predecessor(root);
                root.left = deleteNode(root.left,  root.val );
            } else {
                root.val = successor(root);
                root.right = deleteNode(root.right,  root.val );
            }
        }
        return root;
    }
}
