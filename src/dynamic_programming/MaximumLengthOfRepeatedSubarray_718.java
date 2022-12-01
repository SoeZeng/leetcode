package dynamic_programming;

import java.util.Scanner;

public class MaximumLengthOfRepeatedSubarray_718 {

    public static void main(String[] args) {
        Solution718 sol = new Solution718();
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
            int res = sol.findLength(nums1, nums2);
            System.out.println(res);
        }
    }
}

class Solution718 {

    /**
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {

        // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        // int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // int res = Integer.MIN_VALUE;

        // for(int i = 1; i <= nums1.length; i++) {
        //     for(int j = 1; j <= nums2.length; j++) {
        //         if(nums1[i - 1] == nums2[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         }
        //         if(dp[i][j] > res) res = dp[i][j];
        //     }
        // }

        // return res;

        // 滚动数组
        int[] dp = new int[nums2.length + 1];
        int res = Integer.MIN_VALUE;

        for(int i = 1; i <= nums1.length; i++) {
            for(int j = nums2.length; j >= 1; j--) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                if(res < dp[j]) res = dp[j];
            }
        }
        return res;
    }
}
