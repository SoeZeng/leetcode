package linked_list;

public class LinkedListCycle2_142 {

    public static void main(String[] args) {

    }

    static public class Solution {

        /**
         * @param head 头节点
         * @return 返回链表开始入环的第一个节点。如果链表无环，则返回 null。
         */
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast) {
                    slow = head;
                    while(fast != null && slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return fast;
                }
            }

            return null;
        }
    }
}
