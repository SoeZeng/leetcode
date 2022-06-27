package extra;

import java.util.Scanner;

public class SplitAStringInBalancedString_1221 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int ans = sol.balancedStringSplit(s);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
         *
         * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
         *
         * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
         *
         * 返回可以通过分割得到的平衡字符串的 最大数量 。
         *
         * @param s
         * @return
         */
        public int balancedStringSplit(String s) {
            // int len = s.length();
            // char[] chars = s.toCharArray();
            // // dp[0]表示字符串从开始到当前位置字符'L'的数量
            // // dp[1]表示字符串从开始到当前位置字符'R'的数量
            // int[] dp = new int[2];
            // int res = 0;

            // for(int i = 0; i < len; i++) {
            //     if(chars[i] == 'L') {
            //         dp[0]++;
            //     } else {
            //         dp[1]++;
            //     }

            //     if(dp[0] == dp[1]) res++;
            // }

            // return res;

            int result = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'R') count++;
                else count--;
                if (count == 0) result++;
            }
            return result;
        }
    }
}
