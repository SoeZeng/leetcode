package extra.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfTheLIS_673 {

    public static void main(String[] args) {
        Solution673 sol = new Solution673();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int res = sol.findNumberOfLIS(nums);
            System.out.println(res);
        }
    }
}

class Solution673 {

    /**
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     *
     * 注意 这个数列必须是 严格 递增的。
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i]表示从0到i，最长递增子序列的长度（该递增子序列一定是包括nums[i]的）
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        // 以nums[i]为结尾的数组，最长递增子序列的个数为count[i]（该递增子序列一定是包括nums[i]的）
        int[] count = new int[n];
        Arrays.fill(count,1);
        int max = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }else if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        int res = 0;
        // 统计结果
        for(int i = 0; i < n; i++) {
            if(dp[i] == max) res += count[i];
        }

        return res;
    }
}
