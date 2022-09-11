package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {

    public static void main(String[] args) {

    }
}

class Solution111 {

    /**
     *
     * @param root 二叉树根节点
     * @return 二叉树最小深度
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            ans++;

            while(len > 0) {
                TreeNode p = que.poll();
                if(p.left == null && p.right == null) return ans;

                if(p.left != null) que.offer(p.left);
                if(p.right != null) que.offer(p.right);
                len--;
            }
        }

        return ans;
    }
}


