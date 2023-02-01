package extra.binary_tree;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers_129 {

    public static void main(String[] args) {

    }
}

class Solution129 {
    int sum = 0;

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<Integer> path = new LinkedList<>();
        path.add(root.val);
        traversal(root,path);
        return sum;
    }

    public void traversal(TreeNode root, List<Integer> path) {
        if(root.left == null && root.right == null) {
            int len = path.size();
            for(int i = 0; i < len; i++) {
                sum += path.get(i) * Math.pow(10,len - 1 - i);
            }

//                int temp = 0;
//                for(int num : path) {
//                    temp = temp * 10 + num;
//                }
//                sum += temp;
            return;
        }

        if(root.left != null) {
            path.add(root.left.val);
            traversal(root.left, path);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            path.add(root.right.val);
            traversal(root.right, path);
            path.remove(path.size() - 1);
        }
    }

//    List<Integer> path = new LinkedList<>();
//    int res = 0;
//    public int sumNumbers(TreeNode root) {
//        if(root == null) return 0;
//
//        traversal(root);
//        return res;
//    }
//
//    public void traversal(TreeNode root) {
//
//        if(root.left == null && root.right == null) {
//            int temp = 0;
//            for(int i = 0; i < path.size(); i++) {
//                temp = temp * 10 + path.get(i);
//            }
//            temp = temp * 10 + root.val;
//            res += temp;
//            return;
//        }
//
//        path.add(root.val);
//        if(root.left != null) traversal(root.left);
//        if(root.right != null) traversal(root.right);
//        path.remove(path.size() - 1);
//    }
}
