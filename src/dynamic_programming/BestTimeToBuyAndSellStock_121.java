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
