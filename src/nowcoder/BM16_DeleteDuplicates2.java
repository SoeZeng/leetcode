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
        int count = 0;

        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
                count++;
            } else {
                if(count > 0) {
                    pre.next = cur.next;
                    count = 0;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
        }

        if(count > 0) pre.next = cur.next; //存在比如{1，2，2}，因为删除，所以上述循环条件不进行判断，在此额外进行判断

        return dummyNode.next;
    }
}
