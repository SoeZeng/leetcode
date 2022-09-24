package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {

    public static void main(String[] args) {

    }
}

class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;

        int ans = root.val;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            ans = que.peek().val;

            while(len > 0) {
                TreeNode p = que.poll();
                if(p.left != null) {
                    que.offer(p.left);
                }
                if(p.right != null) {
                    que.offer(p.right);
                }
                len--;
            }
        }

        return ans;
    }
}
