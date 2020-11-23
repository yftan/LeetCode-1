package Microsoft.q103_二叉树的锯齿形层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;

        // 层序遍历，然后加一个判断值向左还是向右。
        Queue<TreeNode> queue = new LinkedList();
        boolean isLeft=true;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            isLeft = !isLeft;
            // 这个地方是Z形遍历的经典之作，如果是从左向右就正常遍历，如果是从右往左，就加在头
            LinkedList<Integer> tmpList = new LinkedList();
            for(int i=0; i < size;i++){
                TreeNode tmp = queue.poll();
                if(isLeft) {
                    tmpList.addFirst(tmp.val);
                } else {
                    tmpList.addLast(tmp.val);
                }
                if(null != tmp.left) {
                    queue.offer(tmp.left);
                }
                if(null != tmp.right) {
                    queue.offer(tmp.right);
                }
            }
            if(tmpList != null && tmpList.size() > 0) {
                res.add(tmpList);
            }

        }
        return res;
    }
}
