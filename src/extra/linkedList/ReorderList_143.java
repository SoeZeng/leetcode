package extra.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReorderList_143 {

    public static void main(String[] args) {
        Solution143 sol = new Solution143();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            ListNode head = null;
            ListNode cur = head;
            for (String s : arr) {
                if (head == null) {
                    head = new ListNode(Integer.parseInt(s));
                    cur = head;
                } else {
                    cur.next = new ListNode(Integer.parseInt(s));
                    cur = cur.next;
                }
            }
            sol.reorderList(head);
        }
    }
}

class Solution143 {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：L0 -> L1 -> ... -> Ln-1 -> Ln
     * 请将其重新排列后变为：L0 -> Ln -> L1 -> Ln-1 -> ...
     *
     * @param head
     */
    public void reorderList(ListNode head) {

        /**
         * 数组模拟
         */
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();

        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        cur = head;
        int l = 1;
        int r = list.size() - 1;
        int count = 0;
        while(l <= r) {
            if(count % 2 == 0) {
                cur.next = list.get(r);
                r--;
            } else {
                cur.next = list.get(l);
                l++;
            }
            cur = cur.next;
            count++;
        }
        cur.next = null; // 记得最后置空！！！

        /**
         * 分割列表
         */
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode cur1 = head;
        ListNode cur2 = reverseList(mid);

        while(cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
