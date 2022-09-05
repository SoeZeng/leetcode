package binary_tree;

import java.util.List;

public class PopulatingNextRightPointersInEachNode_116 {

    public static void main(String[] args) {

    }
}

class BNode {

    public int val;
    public BNode left;
    public BNode right;
    public BNode next;

    public BNode() {}

    public BNode(int _val) {
        val = _val;
    }

    public BNode(int _val, BNode _left, BNode _right, BNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {

    /**
     *
     * @param root 根节点
     * @return 填充每个节点的下一个右侧节点指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
     * 则将 next 指针设置为 NULL。返回按层序遍历排列的序列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     */
    public BNode connect(BNode root) {
//        Queue<Node> que = new LinkedList<>();
//        if(root != null) que.offer(root);
//
//        while(!que.isEmpty()) {
//            int len = que.size();
//
//            while(len > 0) {
//                Node node = que.peek();
//                que.poll();
//
//                if(len > 1) {
//                    node.next = que.peek();
//                }
//
//                if(node.left != null) que.offer(node.left);
//                if(node.right != null) que.offer(node.right);
//                len--;
//            }
//        }
//        return root;

        /*
        在单层遍历的时候记录一下本层的头部节点，然后在遍历的时候让前一个节点指向本节点
         */
//        Queue<Node> tmpQueue = new LinkedList<Node>();
//        if (root != null) tmpQueue.add(root);
//
//        while (tmpQueue.size() != 0){
//            int size = tmpQueue.size();
//
//            Node cur = tmpQueue.poll();
//            if (cur.left != null) tmpQueue.add(cur.left);
//            if (cur.right != null) tmpQueue.add(cur.right);
//
//            for (int index = 1; index < size; index++){
//                Node next = tmpQueue.poll();
//                if (next.left != null) tmpQueue.add(next.left);
//                if (next.right != null) tmpQueue.add(next.right);
//
//                cur.next = next;
//                cur = next;
//            }
//        }
//        return root;



        /*
        思路：上层的next节点已经连接好了
         */
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
