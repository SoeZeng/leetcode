package extra.binary_tree;

public class SameTree_100 {

    public static void main(String[] args) {

    }
}

class Solution100 {

    /**
     *
     * @param p 二叉树根节点
     * @param q 二叉树根节点
     * @return 两棵二叉树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 递归
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        // 迭代
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(p);
//        que.offer(q);
//
//        while(!que.isEmpty()) {
//            TreeNode node1 = que.poll();
//            TreeNode node2 = que.poll();
//            if(node1 == null && node2 == null) {
//                continue;
//            } else if(node1 == null || node2 == null) {
//                return false;
//            } else {
//                if(node1.val != node2.val) return false;
//                que.offer(node1.left);
//                que.offer(node2.left);
//                que.offer(node1.right);
//                que.offer(node2.right);
//            }
//        }
//
//        return true;
    }
}
