package dynamic_programming;

import java.util.Scanner;

public class LongestContinuousIncreasingSubsequence_674 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int res = sol.findLengthOfLCIS(nums);
            System.out.println(res);
        }
    }

    static class Solution {

        /**
         * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
         *
         * @param nums
         * @return
         */
        public int findLengthOfLCIS(int[] nums) {

            // 动规
            // int[] dp = new int[nums.length];

            // int result = 1;
            // Arrays.fill(dp,1);

            // for(int i = 1; i < nums.length; i++) {
            //     if(nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            //     result = Math.max(result, dp[i]);
            // }

            // return result;

            // 贪心
            int res = 1;
            int cnt = 1;
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > nums[i - 1]) cnt++;
                else cnt = 1;
                res = Math.max(res, cnt);
            }

            return res;

        }
    }
}
