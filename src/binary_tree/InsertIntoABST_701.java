package binary_tree;

public class InsertIntoABST_701 {

    public static void main(String[] args) {

    }
}

class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // 递归
        if(root == null) {
            TreeNode p = new TreeNode(val);
            return p;
        }

        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }else {
            root.right = insertIntoBST(root.right, val);
        }

        // 迭代
        TreeNode p = new TreeNode(val);
        TreeNode tempRoot = root;
        TreeNode pre = root;
        while(tempRoot != null) {
            pre = tempRoot;
            if(tempRoot.val > val) {
                tempRoot = tempRoot.left;
            }else if(tempRoot.val < val) {
                tempRoot = tempRoot.right;
            }
        }
        if(pre == null) {
            root = p;
        }else if(pre.val > val) {
            pre.left = p;
        }else {
            pre.right = p;
        }
        return root;

    }

}
