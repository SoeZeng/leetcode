package nowcoder;

import java.util.ArrayList;

public class BM13_IsPalindrome {

}

class Solution_BM13{
    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null) return true;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        for(int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if(!list.get(i).equals(list.get(j))) return false;
        }

        return true;
    }
}
