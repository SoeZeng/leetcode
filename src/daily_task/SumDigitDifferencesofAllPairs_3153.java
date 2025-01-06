package daily_task;

/**
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 *
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 *
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] < 109
 * nums 中的整数都有相同的数位长度。
 */
public class SumDigitDifferencesofAllPairs_3153 {

}

class Solution_3153{
    public long sumDigitDifferences(int[] nums) {
        long result = 0;

        /** 超出时间限制
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                result += digitDifference(nums[i], nums[j]);
            }
        }
         **/

        // 遍历数位处理每一个数
        int[][] cnt = new int[Integer.toString(nums[0]).length()][10];
        for (int k = 0; k < nums.length; k++) {
            int x = nums[k];
            for(int i = 0; x > 0; x /= 10, i++) {
                 result += k - cnt[i][x % 10]++;
            }
        }

        return result;
    }

    private int digitDifference(int x, int y) {
        int diff = 0;
        while(x > 0 && y > 0) {
            if(x % 10 != y % 10) diff++;
            x /= 10;
            y /= 10;
        }
        return diff;
    }
}
