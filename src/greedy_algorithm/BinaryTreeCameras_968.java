package greedy_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class BinaryTreeCameras_968 {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            String str = in.nextLine();
//            String[] arr = str.split(",");
//            dynamic_programming.TreeNode root = null;
//            dynamic_programming.TreeNode p = null;
//            List<dynamic_programming.TreeNode> list = new ArrayList<>();
//            for (int i = 1; i <= arr.length; i++) {
//                if(i == 1) {
//                    root = new dynamic_programming.TreeNode(Integer.parseInt(arr[i - 1]));
//                    list.add(root);
//                } else {
//                    p = list.get(0);
//                    if(2 * i <= arr.length) {
//                        p.left = "null".equals(arr[2 * i - 1]) ? null : new dynamic_programming.TreeNode(Integer.parseInt(arr[2 * i - 1]));
//                        list.add(p.left);
//                    }
//                    if(p != null && 2 * i + 1 <= arr.length) {
//                        p.right = "null".equals(arr[2 * i]) ? null : new dynamic_programming.TreeNode(Integer.parseInt(arr[2 * i]));
//                        list.add(p.right);
//                    }
//                    list.remove(0);
//                }
//            }
//            int ans = sol.minCameraCover(root);
//            System.out.println(ans);
//
//        }
//    }

    static class Solution {
        int ans;

        /**
         * 给定一个二叉树，我们在树的节点上安装摄像头。
         *
         * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
         *
         * 计算监控树的所有节点所需的最小摄像头数量。
         *
         * @param root
         * @return
         */
        public int minCameraCover(TreeNode root) {

            if(traverse(root) == 0) ans++; // 头节点无覆盖
            return ans;
        }

        // 后序遍历：头结点放不放摄像头也就省下一个摄像头，叶子节点放不放摄像头省下了的摄像头数量是指数阶别的，故从下往上遍历
        public int traverse(TreeNode root) {
            // 0：该节点无覆盖
            // 1：该节点有摄像头
            // 2：该节点有覆盖
            if(root == null) return 2;

            int left = traverse(root.left);
            int right = traverse(root.right);

            if(left == 0 || right == 0) {
                ans++;
                return 1;
            }
            if(left == 1 || right == 1) return 2;
            if(left == 2 && right == 2) return 0;

            return -1;
        }


    }
}
