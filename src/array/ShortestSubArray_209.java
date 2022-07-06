package array;

public class ShortestSubArray_209 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给定一个含有n个正整数的数组和一个正整数 target 。
         *
         * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
         * 如果不存在符合条件的子数组，返回 0 。
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;

            for(int right = 0; right < nums.length; right++) {
                sum += nums[right];
//                while(left <= right && sum >= target) {
                while(sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
