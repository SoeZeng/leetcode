package nowcoder;

import java.util.List;

public class InvertsLinkedListsPerKGroups {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;

        int temp = 0;
        ListNode leftNode = pre.next;
        ListNode rightNode = new ListNode(0);
        while (cur != null) {
            temp ++;

            if(temp == k)  {
                rightNode = cur.next;
                cur.next = null;
                reverseLinkedList(leftNode);
                pre.next = cur;
                leftNode.next = rightNode;

                temp = 0;
                pre = leftNode;
                leftNode = rightNode;
                cur = rightNode;
            } else {
                cur = cur.next;
            }

        }

        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
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
