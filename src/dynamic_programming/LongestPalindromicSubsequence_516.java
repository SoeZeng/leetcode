package dynamic_programming;

import java.util.Scanner;

public class LongestPalindromicSubsequence_516 {

    public static void main(String[] args) {
        Solution516 sol = new Solution516();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int res = sol.longestPalindromeSubseq(s);
            System.out.println(res);
        }
    }
}

class Solution516 {

    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n + 1][n + 1];
//            int res = 1;

        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
//                    if(dp[i][j] > res) res = dp[i][j];
            }
        }

//            return res;
        return dp[0][n - 1];
    }
}
