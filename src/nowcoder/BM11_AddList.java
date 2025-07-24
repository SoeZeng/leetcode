package nowcoder;

import java.util.List;

public class BM11_AddList {

}

class Solution_BM11 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        // data overflow
        if(head1 == null) return head2;
        if(head2 == null) return head1;

//        int sum = transform2Num(head1) + transform2Num(head2);
//        ListNode dummy = new ListNode(0);
//        while(sum > 0) {
//            int val = sum % 10;
//            ListNode p = new ListNode(val);
//            p.next = dummy.next;
//            dummy.next = p;
//            sum = sum /10;
//        }
//
//
//        return dummy.next;

        ListNode p1 = reverseList(head1);
        ListNode p2 = reverseList(head2);
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = null;
        int temp = 0;
        while(p1 != null && p2 != null) {
            int sum = p1.val + p2.val + temp;
            temp = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next= dummyNode.next;
            dummyNode.next = node;
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode p = p1 == null ? p2 : p1;
        while(p != null) {
            ListNode tmpNode = p.next;
            int sum = p.val + temp;
            temp = sum / 10;
            p.val = (sum % 10);
            p.next = dummyNode.next;
            dummyNode.next = p;
            p = tmpNode;
        }

        if(temp == 1) {
            ListNode node = new ListNode(temp);
            node.next = dummyNode.next;
            dummyNode.next = node;
        }

        return dummyNode.next;

    }

    private int transform2Num (ListNode head) {
        int val = 0;
        ListNode p = head;
        while(p != null) {
            val = p.val + 10 * val;
            p = p.next;
        }

        return val;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
