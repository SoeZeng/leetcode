package daily_task;

import java.util.Arrays;

/**
 * 给你一个 正 整数数组 nums 。
 *
 * 将 nums 分成两个数组：nums1 和 nums2 ，并满足下述条件：
 *
 * 数组 nums 中的每个元素都属于数组 nums1 或数组 nums2 。
 * 两个数组都 非空 。
 * 分区值 最小 。
 * 分区值的计算方法是 |max(nums1) - min(nums2)| 。
 *
 * 其中，max(nums1) 表示数组 nums1 中的最大元素，min(nums2) 表示数组 nums2 中的最小元素。
 *
 * 返回表示分区值的整数。
 */
public class FindValueOfPartition_2740 {

}

class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }

        return ans;
    }
}
