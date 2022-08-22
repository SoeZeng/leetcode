package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
        Solution94 sol = new Solution94();
    }
}

class Solution94 {
    List<Integer> res = new ArrayList<>();

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * @param root 根节点
     * @return 树节点的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        // 递归
        traverse(root);

        // 迭代
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while(p != null || !stack.empty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }

        // 统一迭代

        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);

    }
}
