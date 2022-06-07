package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock2_122 {
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
            int[][] dp = new int[prices.length][2];

            dp[0][0] = -prices[0];
            dp[0][1] = 0;

            for(int i = 1; i < prices.length; i++) {
                // 股票可以买卖多次！ 所以买入股票的时候，可能会有之前买卖的利润即：dp[i - 1][1]
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            }

            return dp[prices.length - 1][1];
        }
    }
}
