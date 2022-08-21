package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {
        Solution145 sol = new Solution145();
    }
}

class Solution145 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归
        traverse(root);

        // 迭代
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode p = stack.pop();
            res.add(p.val);
            if(p.left != null) {
                stack.push(p.left);
            }
            if(p.right != null) {
                stack.push(p.right);
            }
        }
        Collections.reverse(res);

        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}
