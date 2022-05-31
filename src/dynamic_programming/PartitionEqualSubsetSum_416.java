package dynamic_programming;

import java.util.Scanner;

public class PartitionEqualSubsetSum_416 {

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
            boolean ans = sol.canPartition(nums);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个 只包含正整数 的 非空 数组 nums 。
         * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
         *
         * @param nums
         * @return
         */
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums) sum += num;
            if(sum % 2 != 0) return false;

            int capacity = sum / 2;
            int[] dp = new int[capacity + 1];

            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == capacity) return true;
                for(int j = capacity; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                    if(j == capacity && dp[j] == capacity)  return true;
                }
            }
            return false;

            // int sum = 0;
            // for(int num : nums) sum += num;
            // if(sum % 2 != 0) return false;

            // int capacity = sum / 2;
            // int[] dp = new int[capacity + 1];

            // for(int i = 0; i < nums.length; i++) {
            //     for(int j = capacity; j >= nums[i]; j--) {
            //         dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            //     }
            // }
            // return dp[capacity] == capacity;
        }
    }
}
