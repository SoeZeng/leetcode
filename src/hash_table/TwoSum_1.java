package hash_table;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
         *
         * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
         *
         * @param nums 数组
         * @param target 目标和
         * @return 数组下标
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]),i};
                } else {
                    map.put(target - nums[i], i);
                }
            }

            return null;
        }
    }
}
