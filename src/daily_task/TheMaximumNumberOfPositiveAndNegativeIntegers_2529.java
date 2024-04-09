package daily_task;

/*
给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。

换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
注意：0 既不是正整数也不是负整数。
 */
public class TheMaximumNumberOfPositiveAndNegativeIntegers_2529 {

}

class Solution2529 {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int zero = 0;
        for(int num : nums) {
            if(num > 0) break;
            if(num < 0) neg++;
            else zero++;
        }
        int pos = nums.length - neg - zero;
        return Math.max(pos, neg);
    }
}
