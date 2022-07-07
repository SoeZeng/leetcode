package linked_list;

import java.util.Scanner;

public class RemoveLinkedListElements_203 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            ListNode head;
            if(arr.length == 0) {
                head = null;
            } else {
                head = new ListNode(Integer.parseInt(arr[0]));
            }
            ListNode p = head;
            for (int i = 1; i < arr.length; i++) {
                p.next = new ListNode(Integer.parseInt(arr[i]));
                p = p.next;
            }
            int val = Integer.parseInt(in.nextLine());
            ListNode node = sol.removeElements(head, val);
            System.out.print("[");
            while(node != null) {
                System.out.print(node.val);
                node = node.next;
                if(node != null) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

    static class Solution {

        /**
         *
         * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
         *
         * @param head 头节点
         * @param val 待删除的节点值
         * @return 删除元素后的链表
         */
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyNode = new ListNode(-1,head);
            ListNode pre = dummyNode;
            ListNode cur = head;

            while(cur != null) {
                if(cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }

            return dummyNode.next;
        }
    }
}
