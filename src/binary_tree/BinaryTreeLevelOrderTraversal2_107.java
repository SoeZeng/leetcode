package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2_107 {

    public static void main(String[] args) {

    }
}

class Solution107 {

    /**
     *
     * @param root 根节点
     * @return 二叉树节点的倒序层序遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);

        while(!que.isEmpty()) {
            int len = que.size();
            List<Integer> list = new ArrayList<>();

            while(len > 0) {
                TreeNode p = que.peekFirst();
                que.pollFirst();
                list.add(p.val);

                if(p.left != null) que.offerLast(p.left);
                if(p.right != null) que.offerLast(p.right);
                len--;
            }
            res.add(list);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }

        return result;
    }
}
