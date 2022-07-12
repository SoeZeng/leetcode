package hash_table;

import java.util.*;

public class ThreeSum_15 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
         * 请你找出所有和为 0 且不重复的三元组。
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            /**
             * 哈希表
             */
//            for(int i = 0; i < nums.length; i++) {
//                if(nums[i] > 0) break;
//
//                // 元素a去重
//                if(i > 0 && nums[i] == nums[i - 1]) continue;
//
//                Set<Integer> set = new HashSet<>();
//                for(int j = i + 1; j < nums.length; j++) {
//
//                    // 元素b去重
//                    // if(j > i + 1 && nums[j] == nums[j - 1]) continue; // [0,0,0]
//                    if(j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) continue;
//
//                    int temp = nums[i] + nums[j];
//
//                    // 超时
//                    // for(int k = j + 1; k < nums.length; k++) {
//                    //     if(k > j + 1 && nums[k] == nums[k - 1]) continue;
//
//                    //     if(nums[k] == -temp) {
//                    //         List<Integer> list = new ArrayList<>();
//                    //         list.add(nums[i]);
//                    //         list.add(nums[j]);
//                    //         list.add(nums[k]);
//                    //         res.add(list);
//                    //     }
//                    // }
//
//                    if(set.contains(-temp)) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(-temp);
//                        list.add(nums[j]);
//                        res.add(list);
//                        // 元素c去重
//                        set.remove(-temp);
//                    } else {
//                        set.add(nums[j]);
//                    }
//
//                }
//            }

            /**
             * 双指针
             */
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;

                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;

                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0) {
                        left++;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                    } else if(sum > 0) {
                        right--;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    } else {
                        // List<Integer> list = new ArrayList<>();
                        // list.add(nums[i]);
                        // list.add(nums[left]);
                        // list.add(nums[right]);
                        // res.add(list);
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }

            }

            return res;
        }
    }
}
