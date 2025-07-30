package nowcoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BM12_SortList {

}

class Solution_BM12 {
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;

        ListNode p = head;
        ArrayList<Integer> nums = new ArrayList();
        while(p != null) {
            nums.add(p.val);
            p = p.next;
        }
        Collections.sort(nums);

        p = head;
        for (int j = 0; j < nums.size(); j++) {
            p.val = nums.get(j);
            p = p.next;
        }

        return head;

    }




}
