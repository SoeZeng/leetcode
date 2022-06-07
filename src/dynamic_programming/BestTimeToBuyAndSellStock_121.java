package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] prices = new int[arr.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.maxProfit(prices);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
         *
         * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
         *
         * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            // dp[i][0] 表示第i天持有股票所得最多现金，dp[i][1]表示第i天不持有股票所得最多现金
//            int[][] dp = new int[prices.length][2];
//
//            dp[0][0] = -prices[0];
//            dp[0][1] = 0;
//
//            for(int i = 1; i < prices.length; i++) {
//                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
//            }
//
//            return dp[prices.length - 1][1];

            // 空间优化
            int[][] dp = new int[2][2];

            dp[0][0] = -prices[0];
            dp[0][1] = 0;

            for(int i = 1; i < prices.length; i++) {
                dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], -prices[i]);
                dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
            }

            return dp[(prices.length - 1) % 2][1];
        }
    }
}
