package dynamic_programming;

import java.util.Scanner;

public class DistinctSubsequence_115 {

    public static void main(String[] args) {
        Solution115 sol = new Solution115();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String t = in.nextLine();
            int res = sol.numDistinct(s, t);
            System.out.println(res);
        }
    }
}

class Solution115 {

    /**
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;

        // dp[i][j]表示s以i-1结尾的子串中含t以j-1结尾的子串的个数
        int[][] dp = new int[n1 + 1][n2 + 1];

        // 以i - 1结尾的s中空字符串的个数，以及dp[0][0]，空字符串中空字串的个数
        for(int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(arr1[i - 1] == arr2[j - 1]) {

                    // 用s[i-1]匹配：dp[i - 1][j - 1]
                    // 不用s[i-1]匹配：dp[i - 1][j]，因为此时t[j-1]还没被匹配
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n1][n2];
    }
}
