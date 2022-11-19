package dynamic_programming;

import java.util.Scanner;

public class IntegerBreak_343 {

    public static void main(String[] args) {
        Solution343 sol = new Solution343();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int ans = sol.integerBreak(n);
            System.out.println(ans);
        }
    }

}

class Solution343 {
    /**
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     *
     * 返回 你可以获得的最大乘积 。
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // dp[i]表示整数i拆分后得到的最大乘积
        int[] dp = new int[n + 1];

        // 初始化
        dp[2] = 1;

        // 遍历顺序：从前往后,从1遍历j，然后有两种渠道得到dp[i]:
        // ① j * (i - j) 直接相乘
        // ② j * dp[i - j]，相当于是拆分(i - j)
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, (i - j) * j), dp[i]);
            }
        }

        return dp[n];
    }
}
