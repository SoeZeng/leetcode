package daily_task;

import java.util.Stack;

/*
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k（0 <= k <= nums.length） 。
 *
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 最优子数组的两个端点下标需要满足 i <= k <= j 。
 *
 * 请你返回 最优子数组的最大可能 分数 。
 */
public class MaxiumFraction_1793 {
    public static void main(String[] args) {

    }
}

class Solution1793{
    public int maximumScore(int[] nums, int k) {
        int res = nums[k];
        int n = nums.length;

        // 动态规划 ❌
        /*
        int[][] dp = new int[n][n]; // dp[i][j]表示nums[i],...,nums[k],...,nums[j]之中的最小值
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = k; i >= 0 ; i--) {
            for(int j = k; j < n; j++) {
                if(i != j) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);   // --> dp[k+1][j]和dp[i][k-1]都没有初始化
                }
                res = Math.max(dp[i][j] * (j - i + 1), res);
            }
        }
         **/

        /* ******** 双指针，哪边大就往哪边走 ********
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        /*
        for(int i = k, j = k, min = nums[k]; i > 0 || j < n - 1;) {
            if(j == n - 1 || i > 0 && nums[i - 1] > nums[j + 1]) min = Math.min(min, nums[--i]); // 好妙的if语句，学习！
            else min = Math.min(min, nums[++j]);
            res = Math.max(res, min * (j - i + 1));
        }
         **/

        /* ******** 单调栈，和84.柱状图中最大的矩形面积类似，比栈顶元素小则索引入栈，比栈顶元素大 ********
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        Stack<Integer> stack = new Stack<>();


        return res;
    }
}
