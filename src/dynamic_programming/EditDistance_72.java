package dynamic_programming;

import java.util.Scanner;

public class EditDistance_72 {

    public static void main(String[] args) {
        Solution72 sol = new Solution72();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String word1 = in.nextLine();
            String word2 = in.nextLine();
            int res = sol.minDistance(word1, word2);
            System.out.println(res);
        }
    }
}


class Solution72 {

    /**
     * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
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
                } else {
                    // 添加：dp[i - 1][j] + 1, dp[i][j - 1] + 1，添加和删除的结果是一样的
                    // 替换：dp[i - 1][j - 1] +１
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[cw1.length][cw2.length];
    }
}
