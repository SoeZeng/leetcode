package dynamic_programming;

import java.util.Scanner;

public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            int res = sol.longestCommonSubsequence(s1, s2);
            System.out.println(res);
        }
    }

    static class Solution {

        /**
         * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
         *
         * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后
         * 组成的新字符串。
         *
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence(String text1, String text2) {
            char[] str1 = text1.toCharArray();
            char[] str2 = text2.toCharArray();
            int[][] dp = new int[str1.length + 1][str2.length + 1];

            for(int i = 1; i <= str1.length; i++) {
                for(int j = 1; j <= str2.length; j++) {
                    if(str1[i - 1] == str2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[str1.length][str2.length];
        }
    }
}
