package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {
    public static void main(String[] args) {

    }
}

class Solution113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     *
     * @param root 根节点
     * @param targetSum 返回所有满足给定路径和的路径
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;

        traversal(root, targetSum - root.val);

        return res;
    }

    public void traversal(TreeNode root, int targetSum) {
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if(root.left != null) {
            traversal(root.left, targetSum - root.left.val);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            traversal(root.right, targetSum - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}

