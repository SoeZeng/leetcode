package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        Solution102 sol = new Solution102();
    }
}

class Solution102 {
    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();

            List<Integer> list = new ArrayList<>();
            while(len > 0) {
                TreeNode p = que.poll();
                list.add(p.val);
                if(p.left != null) que.offer(p.left);
                if(p.right != null) que.offer(p.right);
                len--;
            }
            res.add(list);
        }
        return res;
    }
}
