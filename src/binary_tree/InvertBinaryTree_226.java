package binary_tree;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {

    }
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // if(root.left != null) left = invertTree(root.left);
        // if(root.right != null) right = invertTree(root.right);
        // root.right = left;
        // root.left = right;

        /*
        前序遍历
         */
//        TreeNode tempNode = root.left;
//        root.left = root.right;
//        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        /*
        后序遍历
         */
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        return root;
    }
}
