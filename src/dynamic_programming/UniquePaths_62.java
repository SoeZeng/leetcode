package dynamic_programming;

import java.util.Scanner;

public class UniquePaths_62 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int ans = sol.uniquePaths(m, n);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 一个机器人位于一个 m x n网格的左上角
         *
         * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
         *
         * 问总共有多少条不同的路径？
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {

            // 方法一：深搜，机器人走过的路径可以抽象为一棵二叉树，而叶子节点就是终点
            // 超时，时间复杂度为O(2^(m+n-1)-1)
//            return dfs(1,1,m,n);


            // 方法二：DP
            int[][] dp = new int[m][n];
            //初始化
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m-1][n-1];

            // 方法三：数论，无论怎么走，走到终点都需要 m + n - 2 步，在这m + n - 2 步中，一定有 m - 1 步是要向下走的
            // 转换为 --> 给你m + n - 2个不同的数，随便取m - 1个数，有几种取法
//            int numerator = 1; // 分子
//            int denominator = m - 1;
//            int t = 1;
//            for(int i = 0; i < m - 1;i++) {
//                numerator *= t--;
//                while(denominator != 0 && numerator % denominator == 0) {
//                    numerator /= denominator;
//                    denominator--;
//                }
//            }
//            return numerator;
        }

        public int dfs(int i, int j, int m, int n) {
            if(i > m || j > n) return 0;
            if(i == m && j == n) return 1;
            return dfs(i+1, j, m, n) + dfs(i,j+1, m, n);
        }

        public int uniquePaths1(int m, int n) {
            // dp[i][j]表示到达i行j列处的不同路径数
            int[][] dp = new int[m + 1][n + 1];

            // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

            // 初始化
            dp[1][1] = 1;
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == 1 && j == 1) continue;
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m][n];
        }
    }
}
