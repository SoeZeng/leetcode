package binary_tree;

import java.util.Scanner;

public class BuildTreeByPreorderAndInorder_105 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String pre = in.nextLine();
            String[] preArr = pre.split(" ");
            String ino = in.nextLine();
            String[] inArr = ino.split(" ");
            int[] preorder = new int[preArr.length];
            int[] inorder = new int[inArr.length];
            for(int i = 0; i < preorder.length; i++) {
                preorder[i] = Integer.parseInt(preArr[i]);
                inorder[i] = Integer.parseInt(inArr[i]);
            }
            Solution105 sol = new Solution105();
            TreeNode root = sol.buildTree(preorder, inorder);
        }
    }

}

class Solution105 {

    /**
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode findNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart >= preEnd || inStart >= inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = 0;
        while(idx < inorder.length && inorder[idx] != root.val) {
            idx++;
        }
        root.left = findNode(preorder, preStart + 1, preStart + idx - inStart + 1,inorder, inStart, idx);
        root.right = findNode(preorder, preStart + idx - inStart + 1, preEnd, inorder, idx + 1, inEnd);
        return root;

    }
}
