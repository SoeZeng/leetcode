package dynamic_programming;

import java.util.Scanner;

public class MinCostClimbingStairs_746 {

    public static void main(String[] args) {
        Solution746 sol = new Solution746();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] cost = new int[arr.length];
            for (int i = 0; i < cost.length; i++) {
                cost[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.minCostClimbingStairs(cost);
            System.out.println(ans);
        }
    }

}

class Solution746 {
    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
     * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     *
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费.
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        // dp[i]表示爬上第i个阶梯支付的最低费用
        int[] dp = new int[cost.length + 1];

        // dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
