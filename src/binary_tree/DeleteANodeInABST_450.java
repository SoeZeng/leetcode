package binary_tree;

public class DeleteANodeInABST_450 {
    public static void main(String[] args) {

    }
}

class Solution450 {

    /**
     *
     * @param root 二叉搜索树的根节点
     * @param key 要删除的key对应的节点
     * @return 删除节点后的二叉树
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        // 递归
        if(root == null) return root;
        if(root.val == key) {
            if(root.left != null && root.right != null) {
                TreeNode node = root.left;
                while(node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                return root.left;
            }
            if(root.left == null) return root.right;
            return root.left;
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }
}
