package linked_list;

import java.util.Scanner;

public class RemoveTheNthNodeFromEndOfList_19 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            ListNode dummyNode = new ListNode(-1);
            ListNode node = dummyNode;
            String s = in.nextLine();
            String[] arr = s.split(",");
            for (int i = 0; i < arr.length; i++) {
                node.next = new ListNode(Integer.parseInt(arr[i]));
                node = node.next;
            }
            int n = Integer.parseInt(in.nextLine());
            sol.removeNthFromEnd(dummyNode.next, n)
        }
    }

    static class Solution {
        /**
         * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
         * 
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode(-1, head);
            ListNode pre = dummyNode;
            ListNode fast = head;
            ListNode slow = head;

            for(int i = 1; i < n; i++) {
                fast = fast.next;
            }

            while(fast != null && fast.next != null) {
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }

            pre.next = slow.next;
            return dummyNode.next;

        }
    }
}
