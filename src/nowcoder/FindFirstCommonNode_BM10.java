package nowcoder;

public class FindFirstCommonNode_BM10 {

}

class Solution_BM10 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null) return null;

        int n1 = 0;
        int n2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1 != null) {
            p1 = p1.next;
            n1++;
        }

        while(p2 != null) {
            p2 = p2.next;
            n2++;
        }

        ListNode res = n1 > n2 ? firstCommonNode(pHead1, pHead2, n1 - n2) : firstCommonNode(pHead2, pHead1, n2 - n1);
        return res;

    }

    private ListNode firstCommonNode(ListNode p1, ListNode p2, int dis) {
        for (int i = 0; i < dis; i++) {
            p1 = p1.next;
        }

        while(p2 != null && p1 != null) {
            if(p1.val == p2.val) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

}
