package dynamic_programming;

import java.util.Scanner;

public class IsSubsequence_392 {

    public static void main(String[] args) {
        Solution392 sol = new Solution392();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String t = in.nextLine();
            boolean res = sol.isSubsequence(s, t);
            System.out.println(res);
        }
    }
}

class Solution392 {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        // // for(int i = 1; i <= arr1.length; i++) {
        // //     for(int j = 1; j <= arr2.length; j++) {
        // //         if(arr1[i - 1] == arr2[j - 1]) {
        // //             dp[i][j] = dp[i - 1][j - 1] + 1;
        // //         } else {
        // //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        // //         }
        // //     }
        // // }

        // // return dp[arr1.length][arr2.length] == arr1.length;

        // for(int i = 1; i <= arr1.length; i++) {
        //     for(int j = 1; j <= arr2.length; j++) {
        //         if(arr1[i - 1] == arr2[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             dp[i][j] = dp[i][j - 1];
        //         }
        //     }
        // }

        // return dp[arr1.length][arr2.length] == arr1.length;


        // 双指针
        int slow = 0;
        int fast = 0;

        while(slow < arr1.length && fast < arr2.length) {
            if(arr1[slow] == arr2[fast]) {
                slow++;
            }
            fast++;
        }
        return slow == arr1.length;

    }
}
