package dynamic_programming;

import java.util.Scanner;

public class UniqueBinarySearchTrees_96 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int ans = sol.numTrees(n);
            System.out.println(ans);
        }
    }

    static class Solution {
        public int numTrees(int n) {
            // dp[i]表示恰由i个节点组成且节点值从1到i互不相同的二叉搜索树的种数
            int[] dp = new int[n + 1];

            dp[0] = 1;

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= i; j++) {
                    // j-1为j为头结点左子树节点数量，i-j为以j为头结点右子树节点数量
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }

            return dp[n];
        }
    }
}
