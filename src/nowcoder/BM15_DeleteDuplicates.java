package nowcoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BM15_DeleteDuplicates {

}

class Solution_BM15{
    public ListNode deleteDuplicates (ListNode head) {

        ListNode cur = head;

        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;


    }
}