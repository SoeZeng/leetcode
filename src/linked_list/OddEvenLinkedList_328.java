package linked_list;

public class OddEvenLinkedList_328 {
    public static void main(String[] args) {

    }
}

class Solution328 {

    /**
     *
     * @param head 链表头节点
     * @return 将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode oTail = head;
        ListNode eHead = head.next;
        ListNode eTail = eHead;

        while(oTail.next != null && eTail.next != null) {
            oTail.next = eTail.next;
            oTail = oTail.next;
            eTail.next = oTail.next;
            eTail = eTail.next;
        }

        oTail.next = eHead;
        return head;


    }
}
