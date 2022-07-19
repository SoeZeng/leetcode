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
