package binary_tree;

public class CompleteBinaryTreeNodes_222 {

    public static void main(String[] args) {

    }
}

class Solution222 {

    /**
     *
     * @param root 根节点
     * @return 完全二叉树的节点数
     */
    public int countNodes(TreeNode root) {

        // 迭代
        // if(root == null) return 0;
        // int ans = 0;
        // Queue<TreeNode> que = new LinkedList<>();
        // que.offer(root);

        // while(!que.isEmpty()) {
        //     int len = que.size();
        //     ans += len;

        //     while(len > 0) {
        //         TreeNode p = que.poll();
        //         if(p.left != null) que.offer(p.left);
        //         if(p.right != null) que.offer(p.right);
        //         len--;
        //     }
        // }

        // return ans;


        // 递归
        // if(root == null) return 0;

        // int left = countNodes(root.left);
        // int right = countNodes(root.right);

        // return  1 + left + right;

        // 针对完全二叉树的解法
        // 满二叉树的节点数为：2^depth - 1
        if(root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if(leftDepth == rightDepth) { // 左子树是满二叉树
            return (1 << leftDepth) + countNodes(root.right);
        } else { // 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }

    }

    public int getDepth(TreeNode root) {
        int depth = 0;

        while(root != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }

}
