package nowcoder;

import java.util.List;

public class InvertsLinkedListsWithinCompartments {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;

        int dis = n - m + 1;

        while (m-- > 1) {
            p = p.next;
        }

        ListNode q = p.next;
        while(dis-- > 1) {
            q = q.next;
        }

        ListNode left = p.next;
        ListNode right = q.next;

        p.next = null;
        q.next = null;

        reverseList(left);

        p.next = q;
        left.next = right;

        return dummyNode.next;

    }

    private void reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

    }
}
