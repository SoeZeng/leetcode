package nowcoder;

import java.util.List;

public class Merge2SortedLinkedList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode dummyNode = new ListNode(0);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        ListNode cur = dummyNode;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        cur.next = p1 != null ? p1 : p2;

        return dummyNode.next;

    }
}
