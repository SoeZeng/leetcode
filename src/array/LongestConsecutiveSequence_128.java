package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {


}

class Solution128 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return nums.length;

        Arrays.sort(nums);
        int maxCount = 1;
        int ans = maxCount;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) continue;

            if(nums[i] == nums[i - 1] + 1) {
                maxCount++;
                ans = Math.max(ans, maxCount);
            } else {
                maxCount = 1;
            }
        }


        // 时间复杂度：O(n)
//        Map<Integer, Integer> map = new HashMap<>();
//        int ans = 0;
//
//        for(int num : nums) {
//            if(!map.containsKey(num)) {
//                int left = map.getOrDefault(num - 1, 0);
//                int right = map.getOrDefault(num + 1, 0);
//                ans = Math.max(ans, left + right + 1);
//                map.put(num, left + right + 1);
//                map.put(num - left, left + right + 1);
//                map.put(num + right, left + right + 1);
//            }
//
//        }
//
        return ans;
    }
}
