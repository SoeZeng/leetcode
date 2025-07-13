package nowcoder;

public class BM7_EntryNodeOfLoop {

}

class Solution_BM7 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode slow = pHead;
        ListNode fast = pHead;

        while(slow != null && fast != null) {
            slow = slow.next;

            if(fast.next == null) return null;

            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null) return null;

        fast = pHead;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;


    }

}