package extra.linked_list;

public class LinkedListCycle_141 {

    public static void main(String[] args) {

    }

}

class Solution141 {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
