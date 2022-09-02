package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal_429 {

    public static void main(String[] args) {
        Solution429 sol = new Solution429();
    }
}

class Solution429 {

    /**
     *
     * @param root 根节点
     * @return 层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            List<Integer> list = new ArrayList<>();

            while(len > 0) {
                Node p = que.poll();
                list.add(p.val);
                for(int i = 0; i < p.children.size(); i++) {
                    que.offer(p.children.get(i));
                }
                len--;
            }

            res.add(list);
        }

        return res;
    }
}
