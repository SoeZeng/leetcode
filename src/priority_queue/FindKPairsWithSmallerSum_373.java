package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallerSum_373 {

    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
         *
         * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
         *
         * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
         *
         * @param nums1
         * @param nums2
         * @param k
         * @return
         */
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            });
            List<List<Integer>> ans = new ArrayList<>();
            int m = nums1.length;
            int n = nums2.length;

            /*
            如果我们每次都将已选的数对(ai，bi)的待选索引(ai+1，bi),(ai，bi+1)加入到堆中则可能出现重复的问题，
            一般需要设置标记位解决去重的问题。
            我们可以将nums1的前k个索引数对（0，0），（1，0）..，（k-1，0）加入到队列中，每次从队列中取出元素（x，y）时，
            我们只需要将nums2的索引增加即可，这样避免了重复加入元素的问题。
             */
            for (int i = 0; i < Math.min(m, k); i++) {
                pq.offer(new int[]{i,0});
            }

            while (k-- > 0 && !pq.isEmpty()) {
                int[] idxPair = pq.poll();
                List<Integer> list = new ArrayList<>();
                list.add(nums1[idxPair[0]]);
                list.add(nums2[idxPair[1]]);
                ans.add(list);
                if (idxPair[1] + 1 < n) {
                    pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
                }
            }

            return ans;
        }
    }

}
