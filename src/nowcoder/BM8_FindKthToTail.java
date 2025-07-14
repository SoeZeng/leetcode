package nowcoder;

public class BM8_FindKthToTail {

}

class Solution_MB8 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;

        int cnt = 1;
        while(fast != null && cnt <= k) {
            fast = fast.next;
            cnt++;
        }

        if(fast == null && cnt - 1 < k) return null;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
