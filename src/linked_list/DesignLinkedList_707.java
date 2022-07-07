package linked_list;

public class DesignLinkedList_707 {

    public static void main(String[] args) {

    }

    static class MyLinkedList {
        int size;
        ListNode dummyNode;
        public MyLinkedList() {
            size = 0;
            dummyNode = new ListNode(-1);
        }

        public int get(int index) {
            if(index > size - 1 || index < 0){
                return -1;
            }
            ListNode cur = dummyNode;
            for(int i = 0;i <= index;i++){
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = dummyNode.next;
            dummyNode.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode cur = dummyNode;
            for(int i = 0; i<size ;i++){
                cur = cur.next;
            }
            cur.next = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            ListNode node = new ListNode(val);
            ListNode cur = dummyNode;
            if(index <= size){
                for(int i = 0;i < index;i++){
                    cur = cur.next;
                }
                node.next = cur.next;
                cur.next = node;
                size++;
            }

        }

        public void deleteAtIndex(int index) {
            ListNode cur = dummyNode;
            if(index < size){
                for(int i = 0;i < index;i++){
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                size--;
            }

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
