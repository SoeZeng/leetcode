package dynamic_programming;

import java.util.Scanner;

public class ClimbStairs_70 {

    public static void main(String[] args) {
        Solution70 sol = new Solution70();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int ans = sol.climbStairs(n);
            System.out.println(ans);
        }
    }

}

class Solution70 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        // dp[i]表示爬上第i阶阶梯有dp[i]种方法
        int[] dp = new int[n + 1];

        // dp[i] = dp[i - 1] + dp[i - 2]
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        // 完全背包
//        int[] dp = new int[n + 1];
//
//        dp[0] = 1;
//        for(int i = 0; i <= n; i++) {
//            for(int j = 1; j <= 2 && j <= i; j++) {
//                dp[i] += dp[i - j];
//            }
//        }
//
//        return dp[n];
    }
}
