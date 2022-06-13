package dynamic_programming;

import java.util.Scanner;

public class DeleteOperationForTwoStrings_583 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String word1 = in.nextLine();
            String word2 = in.nextLine();
            int res = sol.minDistance(word1, word2);
            System.out.println(res);
        }
    }

    static class Solution {

        /**
         * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
         *
         * 每步 可以删除任意一个字符串中的一个字符。
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            char[] cw1 = word1.toCharArray();
            char[] cw2 = word2.toCharArray();

            int[][] dp = new int[cw1.length + 1][cw2.length + 1];

            for(int i = 1; i <= cw1.length; i++) {
                dp[i][0] = i;
            }
            for(int j = 1; j <= cw2.length; j++) {
                dp[0][j] = j;
            }

            for(int i = 1; i <= cw1.length; i++) {
                for(int j = 1; j <= cw2.length; j++) {
                    if(cw1[i - 1] == cw2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2);
                    }
                }
            }

            return dp[cw1.length][cw2.length];
        }
    }
}
