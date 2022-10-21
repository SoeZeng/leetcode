package binary_tree;

public class MinimumAbsoluteDifferenceOfBST_530 {

    public static void main(String[] args) {

    }
}

class Solution530 {
    int minVal = Integer.MAX_VALUE;
    TreeNode pre = null;

    /**
     *
     * @param root 二叉树根节点
     * @return 最小绝对差值
     */
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minVal;
    }

    public void traversal(TreeNode root) {
        if(root == null) return;

        traversal(root.left);
        if(pre != null && root.val - pre.val < minVal) minVal = root.val - pre.val;
        pre = root;
        traversal(root.right);
    }
}
