package dynamic_programming;

import java.util.Scanner;

public class OneAndZero_474 {

    public static void main(String[] args) {
        Solution474 sol = new Solution474();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] strs = s.split(",");
            int m = in.nextInt();
            int n = in.nextInt();
            int ans = sol.findMaxForm(strs, m, n);
            System.out.println(ans);
        }
    }
}
class Solution474 {

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {

        // dp[i][j]表示i个0，j个1时的最大子集长度
        int[][] dp = new int[m + 1][n + 1];

        for(String str : strs) { // 遍历物品
            int count0 = 0;
            int count1 = 0;
            for(char c : str.toCharArray()) {
                if(c == '0') count0++;
                else count1++;
            }
            for(int i = m; i >= count0; i--) { // 遍历背包，倒序遍历避免覆盖
                for(int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
