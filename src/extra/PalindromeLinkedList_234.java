package extra;

import java.util.Scanner;

public class PalindromeLinkedList_234 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            ListNode head = null;
            ListNode cur = head;
            for(String s : arr) {
                if(head == null) {
                    head = new ListNode(Integer.parseInt(s));
                    cur = head;
                } else {
                    cur.next = new ListNode(Integer.parseInt(s));
                    cur = cur.next;
                }
            }
            boolean ans = sol.isPalindrome(head);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
         *
         * @param head 单链表的头节点
         * @return 判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            ListNode pre = head; // 记录慢指针的前一个节点，用来分割链表
            while(fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            pre.next = null; // 分割链表
            ListNode cur1 = head;
            ListNode cur2 = reverseList(slow);

            while(cur1 != null) {
                if(cur1.val != cur2.val) return false;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return true;
        }

        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
