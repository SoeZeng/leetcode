package linked_list;

public class SwapNodesInPairs_24 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
         * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
         *
         * @param head 头节点
         * @return 成对交换后的链表
         */
        public ListNode swapPairs(ListNode head) {
            ListNode dummyNode = new ListNode(-1,head);
            ListNode pre = dummyNode;
            ListNode cur = head;

            while(cur != null && cur.next != null) {
                ListNode temp = cur.next.next;
                pre.next = cur.next;
                cur.next.next = cur;
                cur.next = temp; // 没有这句则需要while循环结束之后判断是否还存在单个节点
                pre = cur;
                cur = cur.next;
            }
//            if(cur != null) pre.next = cur;
//            else pre.next = null;

            return dummyNode.next;
        }
    }
}
