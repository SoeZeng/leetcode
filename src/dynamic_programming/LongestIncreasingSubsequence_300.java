package dynamic_programming;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int result = sol.lengthOfLIS(nums);
            System.out.println(result);
        }
    }

    static class Solution {

        /**
         * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
         *
         * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            int result = 0;
            int[] dp = new int[nums.length];

            // for(int i = 0; i < nums.length; i++) {
            //     dp[i] = 1;
            // }
            Arrays.fill(dp,1);

            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = dp[i] > result ? dp[i] : result;
            }

            return result;
        }
    }
}
