package dynamic_programming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock4_188 {
    public static void main(String[] args) {
        Solution188 sol = new Solution188();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int k = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] prices = new int[arr.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.maxProfit(k, prices);
            System.out.println(ans);
        }
    }

}

class Solution188 {

    /**
     * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
//            if (prices.length == 0) return 0;
//
//            // [天数][股票状态]
//            // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
//            int[][] dp = new int[prices.length][2 * k + 1];
//
//            for(int i = 1; i < 2 * k; i += 2) {
//                dp[0][i] = -prices[0];
//            }
//
//            for(int i = 1; i < prices.length; i++) {
//                // for(int j = 1; j < 2 * k + 1; j++) {
//                //     dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i] * (int)Math.pow(-1,j));
//                // }
//                for (int j = 0; j < k * 2 - 1; j += 2) {
//                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
//                    dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
//                }
//            }
//
//            return dp[prices.length - 1][2 * k];

        // 空间优化
        int n = 2 * k;
        int[] dp = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            if(i % 2 == 1) {
                dp[i] = -prices[0];
            }
        }

        for(int i = 1; i <= prices.length; i++) {
            for(int j = 1; j <= n; j++) {
                if(j % 2 == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i - 1]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i - 1]);
                }
            }
        }

        return dp[n];
    }

}
