package dynamic_programming;

import java.util.Scanner;

public class CoinChange2_518 {

    public static void main(String[] args) {
        Solution518 sol = new Solution518();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int amount = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] coins = new int[arr.length];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.change(amount, coins);
            System.out.println(ans);
        }
    }
}

class Solution518 {

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     *
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     *
     * 假设每一种面额的硬币有无限个。
     *
     * 题目数据保证结果符合 32 位带符号整数。
     *
     * @param amount 总金额
     * @param coins 硬币金额
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
