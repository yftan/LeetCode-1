package 树的遍历.q662._二叉树最大宽度_BFS;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     *  声明一个内部类记录每个点的位置，只需要关注最左边和最右边的树节点即可，
     *
     *  重点就是记录每个点的位置
     */
    public class Node{
        TreeNode treeNode;
        int pos;
        Node(TreeNode treeNode, int pos){
            this.treeNode = treeNode;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(null == root) return 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0));
        int max= 1;
        while(!queue.isEmpty()){
            // 计算每一层最左边和最右边的节点的差值
            int left = queue.peekFirst().pos;
            int right = queue.peekLast().pos;
            max = Math.max(right-left+1, max);
            int size = queue.size();
            for(int i=0; i< size;i++){
                Node tmpNode = queue.removeFirst();
                TreeNode tmp = tmpNode.treeNode;
                int position = tmpNode.pos;
                if(tmp.left!=null) {
                    queue.add(new Node(tmp.left,position*2));
                }
                if(tmp.right!=null){
                    queue.add(new Node(tmp.right,position*2+1));
                }
            }
        }
        return max;
    }
}
