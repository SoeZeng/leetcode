package daily_task;

import java.util.Arrays;

/*
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

假设每一种面额的硬币有无限个。

题目数据保证结果符合 32 位带符号整数。
 */
public class MoneyChange2_518 {

}

class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[i]表示可组成数额为i的硬币组合数

        dp[0] = 1;

        // 对于coins[i]，初始化dp[coins[i]]=1,则数额大于coins[i]的数值需要更新其组合数，如dp[coins[i]+1]+=dp[1]
        for (int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
