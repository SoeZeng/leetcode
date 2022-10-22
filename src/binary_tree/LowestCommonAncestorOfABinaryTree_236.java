package binary_tree;

public class LowestCommonAncestorOfABinaryTree_236 {

    public static void main(String[] args) {

    }
}

class Solution236 {

    /**
     *
     * @param root 二叉树根节点
     * @param p 指定节点p
     * @param q 指定节点q
     * @return p和的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 为空或找到p、q则返回
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // left和right均非空则表示root即为p和q的最近公共祖先
        if(left != null && right != null) return root;
        if(left == null) return right;
        return left;
    }
}
