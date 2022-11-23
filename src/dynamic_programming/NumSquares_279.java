package dynamic_programming;

import java.util.Scanner;

public class NumSquares_279 {

    public static void main(String[] args) {
        Solution279 sol = new Solution279();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int ans = sol.numSquares(n);
            System.out.println(ans);
        }
    }

}

class Solution279 {

    /**
     *
     * @param n 整数 n
     * @return 和为 n 的完全平方数的最少数量
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] nums = new int[(int)Math.sqrt(n) + 1];

        for(int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i * i <= n; i++) {
            nums[i] = i * i;
            for(int j = nums[i]; j <= n; j++) {
                if(dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }

        return dp[n];
    }
}
