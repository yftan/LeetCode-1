package 树.二叉搜索树相关.q449_序列化和反序列化二叉搜索树;

public class Codec1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root = null;
        for(String value : arr) {
            if(value.length() > 0) {
                root = buildBTSTree(root, Integer.valueOf(value));
            }
        }
        return root;
    }

    public TreeNode buildBTSTree(TreeNode root , int value){
        if(root == null) {
            return new TreeNode(value);
        }
        if( root.val > value) {
            root.left = buildBTSTree(root.left, value);
        } else {
            root.right = buildBTSTree(root.right, value);
        }
        return root;
    }
}
