package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock3_123 {
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
         * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
         *
         * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
         *
         * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            // dp[i][j]，表示的是第i天，0：没有操作，1：第一次买入，2：第一次卖出，3：第二次买入，4：第二次卖出
            int[][] dp = new int[prices.length][5];

            dp[0][1] = -prices[0];
            dp[0][3] = -prices[0];

            for(int i = 1; i < prices.length; i++) {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }

            // 现金最大的时候一定是卖出的状态，而两次卖出的状态现金最大一定是最后一次卖出
            return dp[prices.length - 1][4];
        }
    }
}
