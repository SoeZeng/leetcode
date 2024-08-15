package daily_task;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 *
 * 你有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助你检查
 * 子数组
 *  nums[fromi..toi] 是不是一个 特殊数组 。
 *
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 */
public class SpecificArray2_152 {

}

class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];

        /*
        前缀和
         */
        int[] s = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            s[i] = s[i - 1] + (((nums[i - 1] & 1) == (nums[i] & 1)) ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            ans[i] = s[queries[i][0]] == s[queries[i][1]];
        }

        /*
        记录最近一次奇偶性相同的位置
        lastSame[i] 为 ≤i 的最大下标 j，满足 nums[j−1]mod2=nums[j]mod2。如果没有这样的 j，则 lastSame[i]=0
         */
//        int[] lastSame = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            lastSame[i] = ((nums[i - 1] & 1) == (nums[i] & 1)) ? i : lastSame[i -  1];
//        }
//
//        for(int i = 0; i < queries.length; i++) {
//            int from = queries[i][0];
//            int to = queries[i][1];
//            ans[i] = lastSame[to] <= from;
//        }

        return ans;
    }
}