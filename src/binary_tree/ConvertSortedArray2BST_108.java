package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArray2BST_108 {

    public static void main(String[] args) {

    }
}

class Solution108 {

    /**
     *
     * @param nums 有序数组
     * @return 二叉搜索树
     */
//    Queue<TreeNode> nodes = new LinkedList<>();
//    Queue<Integer> leftIdxs = new LinkedList<>();
//    Queue<Integer> rightIdxs = new LinkedList<>();
    public TreeNode sortedArrayToBST(int[] nums) {

        // 递归
//        TreeNode root = buildBST(nums, 0, nums.length);

        // 迭代
        // 三个队列
        if(nums.length == 0) return null;

        // 输入：[0,1,2,3,4,5,6,7,8]
        // 输出：[4,2,7,1,3,6,8,0,null,5]
        // 预期结果：[4,2,7,1,3,6,8,0,null,null,null,5]
        // leftIdxs.offer(0);
        // leftIdxs.offer(nums.length);
        // TreeNode root = findRoot(nums, leftIdxs);

        // while(!nodes.isEmpty()) {
        //     TreeNode p = nodes.poll();
        //     p.left = findRoot(nums, leftIdxs);
        //     p.right = findRoot(nums, rightIdxs);
        // }

        //根节点初始化
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        // 根节点入队列
        nodeQueue.offer(root);
        // 0为左区间下标初始位置
        leftQueue.offer(0);
        // nums.size() - 1为右区间下标初始位置
        rightQueue.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right - left) >> 1);

            // 将mid对应的元素给中间节点
            currNode.val = nums[mid];

            // 处理左区间
            if (left <= mid - 1) {
                currNode.left = new TreeNode(-1);
                nodeQueue.offer(currNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            // 处理右区间
            if (right >= mid + 1) {
                currNode.right = new TreeNode(-1);
                nodeQueue.offer(currNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }

        return root;
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if(end <= start) return null;

        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }

    // public TreeNode findRoot(int[] nums, Queue<Integer> que) {
    //     if(que.isEmpty()) {

    //     }

    //     int start = que.poll();
    //     int end = que.poll();
    //     int mid = (end - start) / 2 + start;
    //     TreeNode root = new TreeNode(nums[mid]);
    //     nodes.offer(root);
    //     if(mid > start) {
    //         leftIdxs.offer(start);
    //         leftIdxs.offer(mid);
    //     }
    //     if(mid + 1 < end) {
    //         rightIdxs.offer(mid + 1);
    //         rightIdxs.offer(end);
    //     }
    //     return root;

    // }
}
