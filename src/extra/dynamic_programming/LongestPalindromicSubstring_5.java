package extra.dynamic_programming;

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个字符串 s，找到 s 中最长的回文子串。
         *
         * @param s
         * @return
         */
        int left = 0;
        int right = 0;
        public String longestPalindrome(String s) {

            /**
             * 动态规划
             */
            int n = s.length();
            int[][] dp = new int[n][n];
            int max = 1;
            String res = s.substring(0,1);

            for(int i = n - 1; i >= 0; i--) {
                for(int j = i; j < n; j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        // System.out.println(i + "," + j);
                        if(j - i <= 1) {
                            dp[i][j] = j - i + 1;
                        } else if(dp[i + 1][j - 1] > 0){
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }

                    if(max < dp[i][j]) {
                        res = s.substring(i, j + 1);
                        max = dp[i][j];
                    }
                }
            }
            return res;

            /**
             * 双指针
             */
//            int len = s.length();
//            for(int i = 0; i < len; i++) {
//                count(s, i, i, len);
//                count(s, i, i + 1, len);
//            }
//
//            return s.substring(left, right + 1);

        }

//        public void count(String s, int i, int j, int n) {
//            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
//                i--;
//                j++;
//            }
//
//            if(j - i - 2 > right - left) {
//                right = j - 1;
//                left = i + 1;
//            }
//        }
    }
}
