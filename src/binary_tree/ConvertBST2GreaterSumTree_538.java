package binary_tree;

import java.util.Stack;

public class ConvertBST2GreaterSumTree_538 {

    public static void main(String[] args) {

    }
}

class Solution538 {
    TreeNode pre = null;
    int preVal = 0;

    /**
     * @param root 二叉搜索树的根节点
     * @return 累加树：每个节点 node 的新值等于原树中大于或等于 node.val 的值之和
     */
    public TreeNode convertBST(TreeNode root) {
        // 递归
        traversal(root);

        // 迭代
        if(root == null) return root;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur.val += preVal;
                preVal = cur.val;
                cur = cur.left;
            }
        }

        return root;
    }

    public void traversal(TreeNode root) {
        if(root == null) return;

        traversal(root.right);
        if(pre != null) root.val += pre.val;
        pre = root;
        traversal(root.left);
    }
}
