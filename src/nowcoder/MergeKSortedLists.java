package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here

        return mergeList(lists, 0, lists.size() - 1);

    }

    private ListNode mergeList(ArrayList<ListNode> lists, int L, int R) {
        if(L == R) return lists.get(L);

        if (L > R) return null;

        int mid = L + ((R - L) >> 1);
        return merge(mergeList(lists, L ,mid), mergeList(lists, mid + 1, R));
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        cur.next = h1 != null ? h1 : h2;

        return dummyNode.next;
    }
}
