package dynamic_programming;

import java.util.Scanner;

public class HouseRobber_198 {

    public static void main(String[] args) {
        Solution198 sol = new Solution198();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.rob(nums);
            System.out.println(ans);
        }
    }
}

class Solution198 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length]; // dp[i]表示到第i个房屋偷盗的最大金额数
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

//    public int rob1(int[] nums) {
//        // dp[i]表示偷窃到第i号房屋的最高金额
//        if(nums.length == 1) return nums[0];
//
//        int[] dp = new int[nums.length];
//
//        for(int i = 0; i < nums.length; i++) {
//            if(i < 2) dp[i] = nums[i];
//            else if(i == 2) dp[i] = dp[i - 2] + nums[i];
//            else dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
//        }
//
//        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
//    }
}
