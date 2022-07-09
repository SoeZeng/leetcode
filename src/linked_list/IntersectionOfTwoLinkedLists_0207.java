package linked_list;

public class IntersectionOfTwoLinkedLists_0207 {

    public static void main(String[] args) {

    }

    static public class Solution {

        /**
         * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
         *
         * @param headA 单链表的头节点 headA
         * @param headB 单链表的头节点 headB
         * @return 返回交叉节点
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode nodeA = headA;
            ListNode nodeB = headB;

            /**
             * 设c为交叉部分的长度(c可等于0)，a + c + b = b + c + a
             */
            while(nodeA != nodeB) {
                nodeA = nodeA == null ? headB : nodeA.next;
                nodeB = nodeB == null ? headA : nodeB.next;
            }


            /**
             * 先求长度差，再比较
             */
            int lenA = 0;
            int lenB = 0;
            while(nodeA != null) {
                lenA++;
                nodeA = nodeA.next;
            }
            while(nodeB != null) {
                lenB++;
                nodeB = nodeB.next;
            }
            if(lenA > lenB) return getIntersectionNode(headB, headA);

            nodeA = headA;
            nodeB = headB;

            while(lenA < lenB) {
                nodeB = nodeB.next;
                lenB--;
            }

            while(nodeA != nodeB) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }

            return nodeA;
        }
    }
}
