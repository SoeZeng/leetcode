package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {
        Solution145 sol = new Solution145();
    }
}

class Solution145 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}
