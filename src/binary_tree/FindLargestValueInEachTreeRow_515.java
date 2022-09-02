package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow_515 {

    public static void main(String[] args) {
        Solution515 sol = new Solution515();
    }
}

class Solution515 {

    /**
     *
     * @param root  根节点
     * @return 二叉树每一层的最大值
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            int max = que.peek().val;

            while(len > 0) {
                TreeNode p = que.poll();
                max = p.val > max ? p.val : max;

                if(p.left != null) que.offer(p.left);
                if(p.right != null) que.offer(p.right);
                len--;
            }

            res.add(max);
        }

        return res;
    }
}
