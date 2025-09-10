package nowcoder;

public class BM16_DeleteDuplicates2 {

}

class Solution_BM16 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        //if(head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;

        while(cur != null) {
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                    pre.next = cur.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }

        return dummyNode.next;
    }
}
