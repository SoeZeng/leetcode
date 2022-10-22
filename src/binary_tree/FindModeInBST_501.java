package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBST_501 {

    public static void main(String[] args) {

    }
}

class Solution501 {
    int maxCnt = 0;
    int tempCnt = 0;
    TreeNode pre = null;
    List<Integer> list = new ArrayList<>();

    /**
     *
     * @param root 二叉搜索树热根节点
     * @return 二叉搜索树的众数
     */
    public int[] findMode(TreeNode root) {

        // 不使用额外空间
        traversal(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void traversal(TreeNode root) {
        if(root == null) return;

        traversal(root.left);
        if(pre != null && pre.val == root.val) {
            tempCnt++;
        }else {
            tempCnt = 1;
        }

        if(tempCnt == maxCnt) {
            list.add(root.val);
        } else if(tempCnt > maxCnt) {
            maxCnt = tempCnt;
            list.clear();
            list.add(root.val);
        }
        pre = root;
        traversal(root.right);

    }
}
