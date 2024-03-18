package daily_task;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个满足下述规则的二叉树：
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * 请你先还原二叉树，然后实现 FindElements 类：
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 */

public class findElements {
    TreeNode root;

    // Method 1
    /**
    List<Integer> vals = new ArrayList();
    public findElements(TreeNode root) {
        if(root != null) {
            root.val = 0;
            traversingBinaryTree(root);
        }
        this.root = root;
    }

    public boolean find(int target) {
        return this.vals.indexOf(target) == -1 ? false : true;
    }

    public void traversingBinaryTree(TreeNode root) {
        int val = root.val;
        this.vals.add(val);
        if(root.left != null) {
            root.left.val = val * 2 + 1;
            traversingBinaryTree(root.left);
        }
        if(root.right != null) {
            root.right.val = val * 2 + 2;
            traversingBinaryTree(root.right);
        }
    }
     **/

    // Method 2
    Set<Integer> elements = new HashSet<>();
    public findElements(TreeNode root) {
        dfs(root, 0);
        this.root = root;
    }

    public boolean find(int target) {
        return elements.contains(target);
    }

    private void dfs(TreeNode root, int val) {
        if(root == null) return;

        root.val = val;
        this.elements.add(val);
        dfs(root.left, val * 2 + 1);
        dfs(root.right, val * 2 + 2);
    }

    // Method 3 不用还原树，只判断target是否存在，直接位运算解析看树里面有没有这个node就行了

}
