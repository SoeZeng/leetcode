package binary_tree;

public class LowestCommonAncestorOfBST_235 {

    public static void main(String[] args) {

    }
}

class Solution235 {

    /**
     *
     * @param root 二叉搜索树根节点
     * @param p 指定节点p
     * @param q 指定节点q
     * @return p和q的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归
        // if(root.val > p.val && root.val > q.val) {
        //     return lowestCommonAncestor(root.left, p, q);
        // }else if(root.val < p.val && root.val < q.val) {
        //     return lowestCommonAncestor(root.right, p, q);
        // }else {
        //     return root;
        // }

        // 迭代
        while(root != null) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }else {
                return root;
            }
        }

        return null;
    }
}
