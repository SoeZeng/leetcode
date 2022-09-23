package binary_tree;

import java.util.Stack;

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

        // 递归
//        int ans = traversal(root);

        // 递归
        int ans = 0;

        if(root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode p = stack.pop();
            if(p.left != null) {
                stack.push(p.left);
                if(p.left.left == null && p.left.right == null) {
                    ans += p.left.val;
                }
            }
            if(p.right != null) {
                stack.push(p.right);
            }
        }

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
