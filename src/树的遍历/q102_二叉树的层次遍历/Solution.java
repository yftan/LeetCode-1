package 树的遍历.q102_二叉树的层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 利用队列迭代 o(n)
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            levels.add(new ArrayList<>());

            int levelLength = queue.size();

            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> resSub =  new ArrayList();
            // 重点就是这个size，通过他就知道每层有几个元素了
            int size = q.size();

            for(int i=0; i< size; i++) {
                TreeNode tmp = q.remove();
                resSub.add(tmp.val);
                if(tmp.left != null ) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            res.add(resSub);
        }
        return res;

    }

}
