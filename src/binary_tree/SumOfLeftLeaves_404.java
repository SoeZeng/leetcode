package binary_tree;

public class SumOfLeftLeaves_404 {

    public static void main(String[] args) {

    }
}

class Solution404 {

    /**
     *
     * @param root 根节点
     * @return 左叶子之和
     */
    public int sumOfLeftLeaves(TreeNode root) {

        int ans = traversal(root);
        return ans;

    }

    public int traversal(TreeNode root) {

        if(root == null) return 0;

        int left = traversal(root.left); //左
        if(root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        }

        int right = traversal(root.right); // 右

        return left + right; // 中
    }
}
