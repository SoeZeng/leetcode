package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int fee = Integer.parseInt(in.nextLine());
            String[] arr = s.split(",");
            int[] prices = new int[arr.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.maxProfit(prices, fee);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
         *
         * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
         *
         * 返回获得利润的最大值。
         *
         * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            int[][] dp = new int[len][2];

            dp[0][0] = -prices[0];
            dp[0][1] = 0;

            for(int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            }

            return dp[len - 1][1];
        }
    }
}
