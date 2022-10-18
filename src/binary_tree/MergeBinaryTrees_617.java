package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeBinaryTrees_617 {

    public static void main(String[] args) {

    }
}

class Solution617 {

    /**
     *
     * @param root1 二叉树根节点1
     * @param root2 二叉树根节点2
     * @return 合并后的二叉树根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        // 使用栈迭代
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            node1.val += node2.val;
            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }

        // 使用队列迭代
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root1);
        que.offer(root2);

        while(!que.isEmpty()) {

            TreeNode p1 = que.poll();
            TreeNode p2 = que.poll();
            p1.val = p1.val + p2.val;

            if(p1.left != null && p2.left != null) {
                que.offer(p1.left);
                que.offer(p2.left);
            }else if(p1.left == null && p2.left != null) {
                p1.left = p2.left;
            }

            if(p1.right != null && p2.right != null) {
                que.offer(p1.right);
                que.offer(p2.right);
            } else if(p1.right == null && p2.right != null) {
                p1.right = p2.right;
            }
        }
        return root1;

        // 递归
//        TreeNode root = new TreeNode(root1.val + root2.val);
//        root.left = mergeTrees(root1.left, root2.left);
//        root.right = mergeTrees(root1.right, root2.right);
//
//        return root;
    }
}
