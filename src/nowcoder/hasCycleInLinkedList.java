package nowcoder;

public class hasCycleInLinkedList {

    public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while(slow != null && fast != null) {
                slow = slow.next;
                if(fast.next == null) return false;
                fast = fast.next.next;
                if(slow == fast) return true;
            }

            return false;

        }
    }

}
