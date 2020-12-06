package 二叉搜索树相关.q449_序列化和反序列化二叉搜索树;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    // 使用前序遍历方式存储
    public void preOrder(TreeNode root, StringBuilder sb) {
        if(root == null) return ;
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
        String[] arrs = data.split(",");
        TreeNode root = null;
        for(String item: arrs) {
            // 因为最后一个是空串
            if(item.length() > 0){
                root=buildBTSTree(root, Integer.valueOf(item));
            }
        }
        return root;
    }

    /**
     * 重点实现一下，循环加递归生成的
     *
     * @param root
     * @param value
     * @return
     */
    public TreeNode buildBTSTree( TreeNode root, int value){
        if(root ==null) {
            return new TreeNode(value);
        }
        if(root.val > value) {
            root.left = buildBTSTree(root.left, value);
        } else {
            root.right = buildBTSTree(root.right, value);
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;