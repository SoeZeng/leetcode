package dynamic_programming;

import java.util.Scanner;

public class TargetSum_494 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            int target = Integer.parseInt(in.nextLine());
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int ways = sol.findTargetSumWays(nums, target);
            System.out.println(ways);
        }
    }

    static class Solution {

        /**
         * 给你一个整数数组 nums 和一个整数 target 。
         *
         * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
         *
         * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
         * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
         *
         * @param nums
         * @param target
         * @return
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++) sum += nums[i];

            // left - right = target, left + right = sum -> left = (target + sum) / 2
            if(Math.abs(target) > sum || (target + sum) % 2 == 1) return 0;

            int capacity = (target + sum) / 2;
            // dp[j]表示运算结果等于j的不同表达式数目
            int[] dp = new int[capacity + 1];

            dp[0] = 1;

            for(int i = 0; i < nums.length; i++) {
                for(int j = capacity; j >= nums[i]; j--) {
                    // 在求装满背包有几种方法的情况下，递推公式一般为 dp[j] += dp[j - nums[i]]
                    dp[j] += dp[j - nums[i]];
                }
            }

            return dp[capacity];

        }
    }
}
