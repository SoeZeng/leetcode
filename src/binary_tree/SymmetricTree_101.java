package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {

    public static void main(String[] args) {

    }
}

class Solution101 {

    /**
     *
     * @param root 根节点
     * @return 二叉树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        /*
        递归：遍历只能是“后序遍历”，因为我们要通过递归函数的返回值来判断两个子树的内侧节点和外侧节点是否相等。
        正是因为要遍历两棵树而且要比较内侧和外侧节点，所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中。
         */
        // return compare(root.left, root.right);

        /*
        迭代：用队列
         */
        if(root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);

        while(!que.isEmpty()) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();

            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            que.offer(left.left);
            que.offer(right.right);
            que.offer(left.right);
            que.offer(right.left);
        }

        return true;


    }

    public boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(right.val != left.val) return false;

        boolean Outside = compare(left.left, right.right);
        boolean Inside = compare(left.right, right.left);

        return Outside && Inside;
    }


}
