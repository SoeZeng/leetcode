package dynamic_programming;

import java.util.Scanner;

public class PalindromicSubstrings_647 {

    public static void main(String[] args) {
        Solution647 sol = new Solution647();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int res = sol.countSubstrings(s);
            System.out.println(res);
        }
    }
}

class Solution647 {

    int res = 0;

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        // 动态规划
        // int n = s.length();
        // char[] chars = s.toCharArray();
        // boolean[][] dp = new boolean[n][n];
        // int result = 0;

        // for(int i = n - 1; i >= 0; i--) {
        //     for(int j = i; j < n; j++) {
        //         if(chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
        //             dp[i][j] = true;
        //             result++;
        //         }
        //     }
        // }

        // return result;

        // 中心扩散法
        int n = s.length();
        char[] chars = s.toCharArray();


        for(int i = 0; i < n; i++) {
            count(chars, i, i); // 回文串长度为奇数
            count(chars, i, i + 1); // 回文串长度为偶数
        }

        return res;

    }

    public void count(char[] chars, int left, int right) {
        while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
            res++;
            left--;
            right++;
        }
    }
}
