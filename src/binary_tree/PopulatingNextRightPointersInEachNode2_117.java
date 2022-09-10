package binary_tree;

public class PopulatingNextRightPointersInEachNode2_117 {

    public static void main(String[] args) {

    }
}

class Solution117 {

    /**
     * @param root 根节点
     * @return 填充每个节点的下一个右侧节点指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
     * 则将 next 指针设置为 NULL。返回按层序遍历排列的序列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     */
    public Node1 connect(Node1 root) {
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

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    public Node1 getNext(Node1 node) {
        if(node == null) return null;
        if(node.left != null) return node.left;
        if(node.right != null) return node.right;
        if(node.next != null) return getNext(node.next);
        return null;

    }

}


