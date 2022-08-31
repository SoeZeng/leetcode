package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
    public static void main(String[] args) {

    }
}

class Solution637 {
    /**
     *
     * @param root 根节点
     * @return 二叉树的层平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            int sum = 0;

            for(int i = len; i > 0; i--) {
                TreeNode p = que.poll();
                sum += p.val;

                if(p.left != null) que.offer(p.left);
                if(p.right != null) que.offer(p.right);
            }
            double avg = sum / len;
            res.add(avg);
        }

        return res;
    }
}
