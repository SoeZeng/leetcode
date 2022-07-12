package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for(int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i] == nums[i - 1]) continue;

                for(int j = i + 1; j < nums.length; j++) {
                    if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                    int left = j + 1;
                    int right = nums.length - 1;

                    while(left < right) {
                        // nums[k] + nums[i] + nums[left] + nums[right] > target 会溢出
                        long sumL = nums[i] + nums[j];
                        long sumR = nums[left] + nums[right];

                        if(sumL < target - sumR) {
                            left++;
                            while(left < right && nums[left] == nums[left - 1]) left++;
                        } else if(sumL > target - sumR) {
                            right--;
                            while(left < right && nums[right] == nums[right + 1]) right--;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                            while(left < right && nums[left] == nums[left - 1]) left++;
                            while(left < right && nums[right] == nums[right + 1]) right--;
                        }
                    }
                }
            }

            return res;


        }
    }
}
