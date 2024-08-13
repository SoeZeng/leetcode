package daily_task;

/**
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 *
 * Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 */
public class SpecificArray1_3151 {

}

class Solution3151 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if((nums[i] & 1) == (nums[i - 1] & 1)) {
                return false;
            }
        }

        return true;
    }
}
