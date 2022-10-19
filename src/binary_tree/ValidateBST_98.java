package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {

    public static void main(String[] args) {

    }
}

class Solution98 {
    List<Integer> list = new ArrayList<>();

    /**
     *
     * @param root 二叉树根节点
     * @return 该二叉树是否是搜索二叉树
     */
    public boolean isValidBST(TreeNode root) {
        inoderTraversal(root);

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void inoderTraversal(TreeNode root) {
        if(root == null) return;

        inoderTraversal(root.left);
        list.add(root.val);
        inoderTraversal(root.right);
    }
}
