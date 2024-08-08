package daily_task;

import java.util.Arrays;

/**
 * 给你两个长度相等的数组 nums1 和 nums2。
 *
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 *
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 *
 * 返回整数 x 。
 */
public class findIntegerPlusArrays_3131 {

}

class Solution3131 {
    /**
     * @param nums1
     * @param nums2
     * @return 最小值之差
     */
    public int addedInteger(int[] nums1, int[] nums2) {

        // 直接排序
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);

//        return nums2[0] - nums1[0];

        // 求得最小值相减
        return min(nums2) - min(nums1);
    }

    private int min(int[] nums) {
        int x = Integer.MAX_VALUE;

        for(int num : nums) {
            x = Math.min(x, num);
        }

        return x;
    }
}
