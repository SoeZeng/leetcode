package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {

    public static void main(String[] args) {

    }
}

class Solution513 {

    /**
     *
     * @param root 根节点
     * @return 二叉树左下角的值
     */
    int maxDepth = Integer.MIN_VALUE; //记录最大深度
    int ans; // 记录最大深度最左节点的数值
    public int findBottomLeftValue(TreeNode root) {

        // 迭代
//        if(root == null) return 0;
//
//        int ans = root.val;
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//
//        while(!que.isEmpty()) {
//            int len = que.size();
//            ans = que.peek().val;
//
//            while(len > 0) {
//                TreeNode p = que.poll();
//                if(p.left != null) {
//                    que.offer(p.left);
//                }
//                if(p.right != null) {
//                    que.offer(p.right);
//                }
//                len--;
//            }
//        }
//
//        return ans;

        // 递归
        traverse(root,0);

        return ans;
    }

    // 前序遍历
    public void traverse(TreeNode root, int depth) {

        if(root.left == null && root.right == null) {
            if(depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
                return;
            }
        }

        if(root.left != null) traverse(root.left, depth + 1);
        if(root.right != null) traverse(root.right, depth +1);
    }
}
