package linked_list;

public class SortList_148 {

    public static void main(String[] args) {

    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = mergeSort(slow.next);
        slow.next = null;
        ListNode left = mergeSort(head);
        return mergeList(left, right);

    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;

        while(left != null && right != null) {
            if(left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }

            p = p.next;
        }

        p.next = (left == null ? right : left);
        return dummyNode.next;
    }
}