package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Paths_257 {

    public static void main(String[] args) {
        Solution257 sol = new Solution257();
        TreeNode root = new TreeNode();
        List<String> res = sol.binaryTreePaths(root);

    }
}

class Solution257 {
    List<String> res = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     *
     * @param root 根节点
     * @return 二叉树的所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) return res;

        // 递归
//        traverse(root);

        // 迭代
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val + "");

        while(!stack.empty()) {
            String path = (String)stack.pop();
            TreeNode p = (TreeNode) stack.pop();

            if(p.left == null && p.right == null) {
                res.add(path);
            }

            if(p.right != null) {
                stack.push(p.right);
                stack.push(path + "->" + p.right.val);
            }

            if(p.left != null) {
                stack.push(p.left);
                stack.push(path + "->" + p.left.val);
            }


        }

        return res;

    }

    public void traverse(TreeNode root) {
        paths.add(root.val);

        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        if(root.left != null) {
            traverse(root.left);
            paths.remove(paths.size() - 1);
        }

        if(root.right != null) {
            traverse(root.right);
            paths.remove(paths.size() - 1);
        }
    }
}
