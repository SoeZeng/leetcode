package nowcoder;

/**
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 */
public class BM14_OddEvenList {

}

class Solution_BM14{
    public ListNode oddEvenList (ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while(even.next != null && even.next.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }

        if(even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = null;
        }
        odd.next = evenHead;
        return head;
    }
}
