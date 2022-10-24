package binary_tree;

public class TrimBST_669 {

    public static void main(String[] args) {

    }
}

class Solution669 {

    /**
     *
     * @param root 二叉搜索树的根节点
     * @param low 最小值
     * @param high 最大值
     * @return 仅包含节点值位于[low,high]的节点的二叉树
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;

        // 如果root（当前节点）的元素小于low的数值，那么应该递归右子树，并返回右子树符合条件的头结点。
        if(root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }

        // 如果root（当前节点）的元素大于low的数值，那么应该递归左子树，并返回左子树符合条件的头结点。
        if(root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
