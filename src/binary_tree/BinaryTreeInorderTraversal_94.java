package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
        Solution94 sol = new Solution94();
    }
}

class Solution94 {
    List<Integer> res = new ArrayList<>();

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * @param root 根节点
     * @return 树节点的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);

    }
}
