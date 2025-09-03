package nowcoder;

public class BM9_RemoveNthFromEnd {
}

class Solution_BM9 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = head;

        int cnt = 1;
        while(fast != null && cnt <= n) {
            fast = fast.next;
            cnt++;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next == null ? null : slow.next.next;

        return dummyNode.next;

    }
}
