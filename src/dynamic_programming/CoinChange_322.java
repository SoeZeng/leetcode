package dynamic_programming;

import java.util.Scanner;

public class CoinChange_322 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int amount = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] coins = new int[arr.length];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.coinChange(coins, amount);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
         *
         * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
         *
         * 你可以认为每种硬币的数量是无限的。
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];

            for(int j = 1; j <= amount; j++) {
                dp[j] = Integer.MAX_VALUE;
            }

            for(int i = 0; i < coins.length; i++) {
                for(int j = coins[i]; j <= amount; j++) {
                    if(dp[j - coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }


}
