package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {

    public static void main(String[] args) {
        Solution144 sol = new Solution144();
    }
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
//        // 递归
//        List<Integer> res = new ArrayList<>();
//        traversal(root, res);

        // 迭代
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) return res;

        stack.push(root);

//        while(!stack.empty()) {
//            TreeNode p = stack.pop();
//            res.add(p.val);
//            if(p.right != null) stack.push(p.right);
//            if(p.left != null) stack.push(p.left);
//
//        }

        // 统一迭代
        while(!stack.empty()) {
            TreeNode p = stack.peek();
            if(p != null) {
                stack.pop();

                if(p.right != null) stack.push(p.right);
                if(p.left != null) stack.push(p.left);

                stack.push(p);
                stack.push(null);
            }else {
                stack.pop();
                p = stack.peek();
                stack.pop();
                res.add(p.val);
            }

        }

        return res;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}
