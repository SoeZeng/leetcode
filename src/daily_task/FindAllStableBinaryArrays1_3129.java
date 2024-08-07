package daily_task;

/**
 * 给你 3 个正整数 zero ，one 和 limit 。
 *
 * 一个二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
 *
 * 0 在 arr 中出现次数 恰好 为 zero 。
 * 1 在 arr 中出现次数 恰好 为 one 。
 * arr 中每个长度超过 limit 的子数组都 同时 包含 0 和 1 。
 * 请你返回 稳定 二进制数组的 总 数目。
 *
 * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
 */
public class FindAllStableBinaryArrays1_3129 {

}

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {

        final int MOD = 1000000007;
        int[][][] dp = new int[zero + 1][one + 1][2];  // dp[i][j][k]表示i个0j个1构成的稳定数组数量，且第i+j个位置填k（0或者1）

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one,limit) ; j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // + MOD 保证答案非负
                dp[i][j][0] = (int) (((long) dp[i - 1][j][0] + dp[i - 1][j][1] + (i > limit ? MOD - dp[i - limit - 1][j][1] : 0)) % MOD);
                dp[i][j][1] = (int) (((long) dp[i][j - 1][0] + dp[i][j - 1][1] + (j > limit ? MOD - dp[i][j - limit - 1][0] : 0)) % MOD);
            }
        }


        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}
