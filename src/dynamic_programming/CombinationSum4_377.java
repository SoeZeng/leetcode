package dynamic_programming;

import java.util.Scanner;

public class CombinationSum4_377 {

    public static void main(String[] args) {
        Solution377 sol = new Solution377();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            int target = Integer.parseInt(in.nextLine());
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.combinationSum4(nums, target);
            System.out.println(ans);
        }
    }

}

class Solution377 {
    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * @param nums 整数数组
     * @param target 目标和
     * @return 满足目标和的不同组合方式，顺序不同的序列被视作不同的组合
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        // 先遍历背包后遍历物品 --> 排列
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }
}
