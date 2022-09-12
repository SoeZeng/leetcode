package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {

    }
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // if(root.left != null) left = invertTree(root.left);
        // if(root.right != null) right = invertTree(root.right);
        // root.right = left;
        // root.left = right;

        /*
        前序遍历
         */
//        TreeNode tempNode = root.left;
//        root.left = root.right;
//        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        /*
        后序遍历
         */
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        // BFS
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//
//        while(!que.isEmpty()) {
//            int len = que.size();
//
//            while(len > 0) {
//                TreeNode p = que.poll();
//                TreeNode tempNode = p.left;
//                p.left = p.right;
//                p.right = tempNode;
//                if(p.left != null) que.offer(p.left);
//                if(p.right != null) que.offer(p.right);
//                len--;
//            }
//        }

        //迭代
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode p = stack.pop();
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
            if(p.right != null) stack.push(p.right);
            if(p.left != null) stack.push(p.left);


        }

        return root;
    }
}
