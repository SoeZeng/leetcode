package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Paths_257 {

    public static void main(String[] args) {

    }
}

class Solution257 {
    List<String> res = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     *
     * @param root 根节点
     * @return 二叉树的所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        traverse(root);
        return res;

    }

    public void traverse(TreeNode root) {
        paths.add(root.val);

        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        if(root.left != null) {
            traverse(root.left);
            paths.remove(paths.size() - 1);
        }

        if(root.right != null) {
            traverse(root.right);
            paths.remove(paths.size() - 1);
        }
    }
}
