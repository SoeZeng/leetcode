package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithCooldown_309 {

    public static void main(String[] args) {
        Solution309 sol = new Solution309();
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
}


class Solution309 {

    /**
     * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
//            int len = prices.length;
//
//            if(len == 1) return 0;
//
//            int[][] dp = new int[len][2];
//
//            dp[0][0] = -prices[0];
//            dp[0][1] = 0;
//            dp[1][0] = Math.max(dp[0][0], -prices[1]);
//            dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
//
//            for(int i = 2; i < len; i++) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//            }
//
//            return dp[len - 1][1];

        // 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
        // 卖出股票状态，这里就有两种卖出股票状态
        // 状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
        // 状态三：今天卖出了股票
        // 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天
//        int len = prices.length;
//
//        int[][] dp = new int[len][4];
//
//        dp[0][0] = -prices[0];
//
//        for(int i = 1; i < len; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
//            dp[i][2] = dp[i - 1][0] + prices[i];
//            dp[i][3] = dp[i - 1][2];
//        }
//
//        return Math.max(dp[len - 1][3], Math.max(dp[len - 1][1], dp[len - 1][2]));

        if(prices.length <= 1) return 0;

        // 0：持有股票，1：不持有股票但不是今天卖出，2：卖出股票
        int[][] dp = new int[prices.length][3];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);

    }
}