package binary_tree;

public class MergeBinaryTrees_617 {

    public static void main(String[] args) {

    }
}

class Solution617 {

    /**
     *
     * @param root1 二叉树根节点1
     * @param root2 二叉树根节点2
     * @return 合并后的二叉树根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
