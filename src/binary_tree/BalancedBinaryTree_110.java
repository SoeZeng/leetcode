package binary_tree;

import java.util.Scanner;

public class BalancedBinaryTree_110 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            Solution110 sol = new Solution110();
            TreeNode root = new TreeNode();
            boolean ans = sol.isBalanced(root);
            System.out.println(ans);
        }

    }
}

class Solution110 {

    /**
     *
     * @param root 根节点
     * @return 给定二叉树是否是平衡二叉树，是则返回true，否则返回false
     */
    public boolean isBalanced(TreeNode root) {
        return getHighDiff(root) == -1 ? false : true;
    }

    public int getHighDiff(TreeNode root) {
        if(root == null) return 0;

        // 若左右子树不是平衡二叉树，返回-1
        int left = getHighDiff(root.left);
        if(left == -1) return -1;
        int right = getHighDiff(root.right);
        if(right == -1) return -1;

        // 若以此节点为根节点的树不是平衡二叉树返回-1，否则返回树的高度
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
