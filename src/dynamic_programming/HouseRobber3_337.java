package dynamic_programming;

import java.util.Scanner;

/**
 * Definition for a binary tree node.
 * public class dynamic_programming.TreeNode {
 *     int val;
 *     dynamic_programming.TreeNode left;
 *     dynamic_programming.TreeNode right;
 *     dynamic_programming.TreeNode() {}
 *     dynamic_programming.TreeNode(int val) { this.val = val; }
 *     dynamic_programming.TreeNode(int val, dynamic_programming.TreeNode left, dynamic_programming.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class HouseRobber3_337 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {


        }
    }

    static class Solution {

        /**
         * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
         *
         * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
         *
         * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
         *
         * @param root
         * @return
         */
        // 暴力递归 -> 超时
        // public int rob(TreeNode root) {
        //     if(root == null) return 0;
        //     if(root.left == null && root.right == null) return root.val;

        //     int val1 = root.val;
        //     if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        //     if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);

        //     int val2 = rob(root.left) + rob(root.right);

        //     return Math.max(val1,val2);
        // }

        // 记忆化递归
        // Map<TreeNode, Integer> map = new HashMap<>();
        // public int rob(TreeNode root) {

        //     if(root == null) return 0;
        //     if(root.left == null && root.right == null) return root.val;
        //     if(map.containsKey(root)) return map.get(root);

        //     int val1 = root.val;
        //     if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        //     if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);

        //     int val2 = rob(root.left) + rob(root.right);

        //     map.put(root, Math.max(val1,val2));

        //     return Math.max(val1,val2);
        // }

        // 动态规划
        public int rob(TreeNode root) {
            int[] result = robTree(root);
            return Math.max(result[0],result[1]);
        }

        // 长度为2的数组，0：不偷，1：偷
        public int[] robTree(TreeNode root) {
            if(root == null) return new int[]{0, 0};

            int[] left = robTree(root.left);
            int[] right = robTree(root.right);

            // 偷当前房屋
            int val1 = root.val + left[0] + right[0];

            // 不偷当前房屋
            int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{val2, val1};
        }
    }
}
