package extra;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BalanceABinarySearchTree_1382 {

    public static void main(String[] args) {

//        System.out.println(Runtime.getRuntime().availableProcessors());
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            String s = in.nextLine();
//            String[] arr = s.split(",");
//            if(arr.length == 0 || "null".equals(arr[0])) {
//                System.out.println("输入有误！请重新输入：");
//                continue;
//            }
//            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
//            Queue<TreeNode> que = new LinkedList<>();
//            que.add(root);
//            int idx = 1;
//            System.out.println(111);
//            while (idx < arr.length) {
//                int len = que.size();
//
//                while(len > 0 && idx < arr.length) {
//                    TreeNode node = que.poll();
//                    if(!"null".equals(arr[idx])) {
//                        node.left = new TreeNode(Integer.parseInt(arr[idx]));
//                        que.add(node.left);
//                    }
//                    idx++;
//                    if(idx < arr.length) {
//                        if(!"null".equals(arr[idx])) {
//                            node.right = new TreeNode(Integer.parseInt(arr[idx]));
//                            que.add(node.right);
//                        }
//                    }
//                    idx++;
//                    len--;
//                }
//            }
//            TreeNode treeNode = sol.balanceBST(root);
//            System.out.println("OK");
//        }
    }

    static class Solution {
        List<Integer> list = new LinkedList<>();

        /**
         * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
         * 如果有多种构造方法，请你返回任意一种。
         *
         * @param root
         * @return
         */
        public TreeNode balanceBST(TreeNode root) {

            // 中序遍历将二叉搜索树转化为有序列表
            traversal(root);

            // 将有序列表转化为二叉平衡树
            return constructAVLTree(list, 0, list.size() - 1);
        }

        public void traversal(TreeNode root) {
            if(root == null) return;

            traversal(root.left);
            list.add(root.val);
            traversal(root.right);
        }

        public TreeNode constructAVLTree(List<Integer> list, int left, int right) {
            if(left > right) return null;

            int idx = left + (right - left) / 2;
            TreeNode node = new TreeNode(list.get(idx));
            node.left = constructAVLTree(list,left,idx - 1);
            node.right = constructAVLTree(list,idx + 1,right);

            return node;
        }
    }
}
