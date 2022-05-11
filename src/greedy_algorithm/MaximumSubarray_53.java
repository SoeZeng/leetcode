package greedy_algorithm;

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = sol.maxSubArray(nums);
        System.out.println(res);
    }

    static class Solution {
        /**
         * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         *
         * 子数组 是数组中的一个连续部分。
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(sum <= 0) {
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
                max = Math.max(max,sum);
            }
            return max;
        }
    }

}

