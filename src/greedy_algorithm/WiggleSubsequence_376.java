package greedy_algorithm;

public class WiggleSubsequence_376 {
    /**
     * 总结：保持区间波动，只需要把单调区间上的元素移除就可以了
     * @param args
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        int res = sol.wiggleMaxLength(nums);
        System.out.println(res);
    }

    static class Solution {
        /**
         * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
         * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
         *
         * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
         *
         * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
         * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
         *
         * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
         *
         * @param nums
         * @return
         */
        // 统计峰值的时候，数组最左面和最右面是最不好统计的 --> 先处理数组中前两个数据
        public int wiggleMaxLength(int[] nums) {

            if(nums.length < 2)  {
                return nums.length;
            }

            int dis1 = nums[1] - nums[0];
            int cnt = dis1 == 0 ? 1 : 2;

            for(int i = 2; i < nums.length; i++) {
                int dis2 = nums[i] - nums[i-1];
                if(dis1 * dis2 < 0 || (dis1 == 0 && dis2 != 0)) {
                    cnt++;
                    dis1 = dis2;
                }

            }
            return cnt;
        }

        // 统计峰值的时候，数组最左面和最右面是最不好统计的 --> 假设数组为[nums[0],nums[0],...],此时preDiff=0,result=1
        public int wiggleMaxLength1(int[] nums) {

            if(nums.length < 2)  {
                return nums.length;
            }

            // 记录当前差值
            int preDiff = 0;
            // 记录摆动序列长度
            int result = 1;

            for(int i = 1; i < nums.length; i++) {
                // 记录当前差值
                int curDiff = nums[i] - nums[i-1];
                if((preDiff <= 0 && curDiff > 0) || ((preDiff >= 0 && curDiff < 0))) {
                    result++;
                    preDiff = curDiff;
                }

            }
            return result;
        }

        // DP
        public int wiggleMaxLength2(int[] nums) {

            // dp状态dp[i][0]，表示考虑前i个数，第i个数作为山峰的摆动子序列的最长长度
            // dp状态dp[i][1]，表示考虑前i个数，第i个数作为山谷的摆动子序列的最长长度
            int[][] dp = new int[nums.length][2];
            // 一个数可以接到前面的某个数后面，也可以以自身为子序列的起点，所以初始状态为：dp[0][0] = dp[0][1] = 1
            dp[0][0] = dp[0][1] = 1;
            for(int i = 1; i < nums.length; i++) {
                //i 自己可以成为波峰或者波谷  !!!这里自己没有想到!!!
                dp[i][0] = dp[i][1] = 1;

                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        // 波峰
                        dp[i][0] = Math.max(dp[i][0],dp[j][1] + 1);
                    }
                    if(nums[i] < nums[j]) {
                        // 波谷
                        dp[i][1] = Math.max(dp[i][1],dp[j][0] + 1);
                    }
                }
            }
            return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        }

    }


}

