package extra;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromePartition2_132 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            Solution sol = new Solution();
            String s = in.nextLine();
            int ans = sol.minCut(s);
            System.out.println(ans);

        }
    }

    static class Solution {
//        int res = 0;

        /**
         * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
         *
         * 返回符合要求的 最少分割次数 。
         *
         * @param s
         * @return
         */
        public int minCut(String s) {

            if(s == null || s.length() <= 1)
                return 0;
            int len = s.length();
            // 范围是[0, i]的回文子串，最少分割次数是dp[i]
            int dp[] = new int[len];
            Arrays.fill(dp, len-1);
            for(int i = 0; i < len; i++){
                // 注意偶数长度与奇数长度回文串的特点
                mincutHelper(s , i , i , dp);  // 奇数回文串以1个字符为中心
                mincutHelper(s, i , i+1 , dp); // 偶数回文串以2个字符为中心
            }
            return dp[len-1];


            /**
             * 思路：当切割次数最少使得切割后的所有字符串都是回文时，也正是这些回文子串最长的时候
             * 解答错误("ebdbddc") 当存在长度相同的回文串时，如"dbd"、"bdb"，会发生错误
             */
//            int n = s.length();
//            char[] chars = s.toCharArray();
//            longestPalindrome(chars,0,n-1);
//            return res - 1;

        }

        private void mincutHelper(String s, int i, int j, int[] dp){
            int len = s.length();
            while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
                dp[j] = Math.min(dp[j] , (i==0?-1:dp[i-1])+1);
                i--;
                j++;
            }
        }

//        public void longestPalindrom(char[] chars, int start, int end) {
//            if(start > end) return;
//
//            int n = end - start + 1;
//            int[][] dp = new int[n][n];
//            int left = 0;
//            int right = 0;
//            int max = 1;
//
//            for(int i = end - start; i >= 0; i--) {
//                for(int j = i; j < n; j++) {
//                    if(chars[i + start] == chars[j + start]) {
//                        if(j - i <= 1) dp[i][j] = j - i + 1;
//                        else if(dp[i + 1][j - 1] > 0) dp[i][j] = dp[i + 1][j - 1] + 2;
//
//                        if(dp[i][j] > max) {
//                            right = j;
//                            left = i;
//                            max = dp[i][j];
//                        }
//                    }
//                }
//            }
//
//            res++;
//            System.out.println(left +"," + right);
//            longestPalindrome(chars,start,start + left - 1);
//            longestPalindrome(chars,start + right + 1,end);
//        }
    }
}
