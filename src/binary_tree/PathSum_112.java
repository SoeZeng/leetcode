package binary_tree;

public class PathSum_112 {

    public static void main(String[] args) {

    }

}

class Solution112 {
    int sum = 0;

    /**
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * @param root 二叉树的根节点
     * @param targetSum 目标和
     * @return 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return traverse(root, targetSum);

//            if (root == null) return false; // 为空退出
//
//            // 叶子节点判断是否符合
//            if (root.left == null && root.right == null) return root.val == targetsum;
//
//            // 求两侧分支的路径和
//            return haspathsum(root.left, targetsum - root.val) || haspathsum(root.right, targetsum - root.val);

    }

    public boolean traverse(TreeNode root, int targetSum) {

        sum += root.val;
        if(root.left == null && root.right == null) {
            return sum == targetSum;
        }

        boolean left = false;
        boolean right = false;

        if(root.left != null) {
            left = traverse(root.left,targetSum);
            sum -= root.left.val;
        }
        if(root.right != null) {
            right = traverse(root.right,targetSum);
            sum -= root.right.val;
        }

        return left || right;
    }
}
