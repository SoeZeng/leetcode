package linked_list;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {

            /**
             * 迭代
             */
            ListNode cur = head;
            head = null;

            while(cur != null) {
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            }

            return head;

            /**
             * 递归
             */
//            ListNode pre = null;
//            ListNode cur = head;
//
//            return reverse(pre, cur);
        }

        public ListNode reverse(ListNode pre, ListNode cur) {
            if(cur == null) return pre;

            ListNode next = cur.next;
            cur.next = pre;
            return reverse(cur, next);

        }
    }
}

