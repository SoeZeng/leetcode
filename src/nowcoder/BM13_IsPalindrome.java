package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class BM13_IsPalindrome {

}

class Solution_BM13{
    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null) return true;

//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode cur = head;
//        while(cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//
//        for(int i = 0, j = list.size() - 1; i < j; i++, j--) {
//            if(!list.get(i).equals(list.get(j))) return false;
//        }
//
//        return true;

        // dual pointer -- fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast =fast.next.next;
        }

        slow = reverse(slow);
        fast = head;
        while(slow != null && fast != null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }


}
