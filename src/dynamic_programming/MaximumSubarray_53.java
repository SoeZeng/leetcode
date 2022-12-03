package dynamic_programming;

import java.util.Scanner;

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        Solution53 sol = new Solution53();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int res = sol.maxSubArray(nums);
            System.out.println(res);
        }
    }
}

class Solution53 {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int res = dp[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if(res < dp[i]) res = dp[i];
        }

        return res;
    }
}
