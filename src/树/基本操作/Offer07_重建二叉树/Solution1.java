package 树.基本操作.Offer07_重建二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrderList = new ArrayList<Integer>();
        List<Integer> inOrderList = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++) {
            preOrderList.add(preorder[i]);
            inOrderList.add(inorder[i]);
        }
        return doBuildTree(preOrderList, inOrderList);
    }

    public TreeNode doBuildTree(List<Integer> preOrder, List<Integer> inOrder ){
        if(inOrder.isEmpty()) return null;
        Integer val = preOrder.remove(0);

        TreeNode root = new TreeNode(val);
        int idx = inOrder.indexOf(val);
        root.left = doBuildTree(preOrder, inOrder.subList(0, idx));
        root.right = doBuildTree(preOrder, inOrder.subList(idx+1, inOrder.size()));
        return root;
    }
}
