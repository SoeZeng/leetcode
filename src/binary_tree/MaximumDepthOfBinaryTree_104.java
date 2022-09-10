package binary_tree;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {

    }
}

class Solution104 {
    public int maxDepth(TreeNode root) {

//        int res = 0;
//        if(root == null) return res;
//
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//
//        while(!que.isEmpty()) {
//            int len = que.size();
//
//            while(len > 0) {
//                TreeNode p = que.poll();
//                if(p.left != null) que.offer(p.left);
//                if(p.right != null) que.offer(p.right);
//                len--;
//            }
//            res++;
//        }
//        return res;
        if(root == null) return 0;
        return traversal(root, 1);
    }

    public int traversal(TreeNode root, int depth) {
        if(root == null) return depth;

        int leftDepth = depth;
        int rightDepth = depth;
        if(root.left != null) leftDepth = traversal(root.left, depth + 1);
        if(root.right != null) rightDepth = traversal(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);

    }
}
