package stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        Solution347 sol = new Solution347();
    }
}

class Solution347 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值，构建于一个大顶堆（o1 - o2: 小顶堆， o2 - o1 : 大顶堆）
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for(Map.Entry<Integer, Integer> entry : entries) {
            pq.offer(entry);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;

    }
}
