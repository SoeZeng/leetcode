package binary_tree;

public class SearchInBST_700 {

    public static void main(String[] args) {

    }
}

class Solution700 {
    /**
     *
     * @param root BST根节点
     * @param val 整数值
     * @return 以节点值为val的节点为根的子树
     */
    public TreeNode searchBST(TreeNode root, int val) {

        // 迭代
//        TreeNode p = root;
//
//        while(p != null) {
//            if(p.val == val) return p;
//            if(p.val < val) {
//                p = p.right;
//            }else {
//                p = p.left;
//            }
//        }

        // 递归
        if(root == null || root.val == val) return root;

        if(root.val > val) return searchBST(root.left,val);
        if(root.val < val) return searchBST(root.right, val);

        return null;
    }
}
