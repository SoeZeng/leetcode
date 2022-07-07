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

            ListNode cur = head;
            head = null;

            while(cur != null) {
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            }

            return head;
        }
    }
}

