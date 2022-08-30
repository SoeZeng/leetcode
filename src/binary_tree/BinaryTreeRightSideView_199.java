package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

    public static void main(String[] args) {

    }
}

class Solution199 {

    /**
     *
     * @param root 根节点
     * @return 二叉树的右视图
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        // 迭代
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        while(!que.isEmpty()) {
            int len = que.size();

            while(len > 0) {
                TreeNode p = que.poll();
                if(len == 1) {
                    res.add(p.val);
                }

                if(p.left != null) que.offer(p.left);
                if(p.right != null) que.offer(p.right);
                len--;
            }
        }

        // 递归
        // getRightNode(root, res, 0);

        return res;
    }

    public void getRightNode(TreeNode root, List<Integer> list, int depth) {
        if(root == null) return;

        if(depth == list.size()) {
            list.add(root.val);
        }

        if(root.right != null) getRightNode(root.right, list, depth + 1);
        if(root.left != null) getRightNode(root.left, list, depth + 1);
    }
}


