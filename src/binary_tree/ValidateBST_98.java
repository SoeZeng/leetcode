package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {

    public static void main(String[] args) {

    }
}

class Solution98 {
    List<Integer> list = new ArrayList<>();
    long maxVal = Long.MIN_VALUE;
    TreeNode pre = null;

    /**
     *
     * @param root 二叉树根节点
     * @return 该二叉树是否是搜索二叉树
     */
    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);

//        for(int i = 1; i < list.size(); i++) {
//            if(list.get(i) <= list.get(i - 1)) {
//                return false;
//            }
//        }
//
//        return true;

        // 记录最大值，边遍历边比较
//        boolean left = isValidBST(root.left);
//        if(root.val <= maxVal) return false;
//        maxVal = root.val;
//        boolean right = isValidBST(root.right);

        // 记录前一个节点
        boolean left = isValidBST(root.left);
        if(pre != null && root.val <= pre.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);

        return left && right;
    }

    public void inorderTraversal(TreeNode root) {
        if(root == null) return;

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
