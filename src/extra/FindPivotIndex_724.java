package extra;

import java.util.Scanner;

public class FindPivotIndex_724 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] strs = s.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int ans = sol.pivotIndex(nums);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个整数数组nums ，请计算数组的 中心下标 。
         *
         * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
         *
         * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
         *
         * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
         *
         * @param nums
         * @return
         */
        public int pivotIndex(int[] nums) {
            int[] leftSum = new int[nums.length];
            int[] rightSum = new int[nums.length];

            leftSum[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i];
            }

            rightSum[nums.length - 1] = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i];
            }

            for(int i = 0; i < nums.length; i++) {
                if(leftSum[i] == rightSum[i]) return i;
            }

//            int sum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                sum += nums[i]; // 总和
//            }
//            int leftSum = 0;
//            int rightSum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                leftSum += nums[i];
//                rightSum = sum - leftSum + nums[i]; // leftSum 里面已经有 nums[i]，多减了一次，所以加上
//                if (leftSum == rightSum) {
//                    return i;
//                }
//            }

            return -1;
        }
    }
}
