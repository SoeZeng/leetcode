package dynamic_programming;

import java.util.Scanner;

public class UncrossedLines_1035 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] arr1 = s1.split(",");
            String[] arr2 = s2.split(",");
            int[] nums1 = new int[arr1.length];
            int[] nums2 = new int[arr2.length];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = Integer.parseInt(arr1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = Integer.parseInt(arr2[i]);
            }
            int res = sol.maxUncrossedLines(nums1, nums2);
            System.out.println(res);
        }
    }

    static class Solution {

        /**
         * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
         *
         * 现在，可以绘制一些连接两个数字 nums1[i]和 nums2[j]的直线，这些直线需要同时满足满足：
         *
         * nums1[i] == nums2[j]
         * 且绘制的直线不与任何其他连线（非水平线）相交。
         * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
         *
         * 以这种方法绘制线条，并返回可以绘制的最大连线数。
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[][] dp = new int[n1 + 1][n2 + 1];

            for(int i = 1; i <= n1; i++) {
                for(int j = 1; j <= n2; j++) {
                    if(nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[n1][n2];
        }
    }
}
