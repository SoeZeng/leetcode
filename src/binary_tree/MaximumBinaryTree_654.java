package binary_tree;

import java.util.Scanner;

public class MaximumBinaryTree_654 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String[] strArr = str.split(" ");
            int[] nums = new int[strArr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strArr[i]);
            }
            Solution654 sol = new Solution654();
            TreeNode treeNode = sol.constructMaximumBinaryTree(nums);
            System.out.println(treeNode.val);
        }
    }
}

class Solution654 {

    /**
     *  最大二叉树 可以用下面的算法从 nums 递归地构建:
     *
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     *
     * @param nums 给定数组
     * @return 最大二叉树的根节点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        // 迭代
//        if(nums.length == 0) return null;
//
//        TreeNode root = new TreeNode(nums[0]);
//        TreeNode newest = root;
//        for(int i = 1; i < nums.length; i++) {
//            TreeNode p = new TreeNode(nums[i]);
//            // System.out.print(p.val);
//            if(nums[i] > root.val) { // 当前被添加的节点值大于根值，则被添加的节点为新的根节点，原来的根节点成为左孩子
//                p.left = root;
//                root = p;
//            } else if(nums[i] < newest.val) { // 当前被添加的节点值小于上一个添加的节点值，则被添加的节点为上一个被添加的节点的右孩子
//                newest.right = p;
//            } else {
//                TreeNode pre = root;
//                while(nums[i] < pre.right.val) { // 找到根节点右子树中第一个小于当前被添加的节点值的节点pre.right
//                    pre = pre.right;
//                }
//                p.left = pre.right;
//                pre.right = p;
//            }
//            newest = p;  // 更新最新被添加的节点
//        }
//        return root;

        // 递归
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int leftIdx, int rightIdx) {
        if(leftIdx >= rightIdx) return null;

        int maxVal = nums[leftIdx];
        int index = leftIdx;
        for(int i = leftIdx; i < rightIdx; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = traversal(nums, leftIdx, index);
        root.right = traversal(nums, index + 1, rightIdx);

        return root;
    }
}
