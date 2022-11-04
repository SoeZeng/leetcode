package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2_90 {

    public static void main(String[] args) {

    }
}

class Solution90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new LinkedList<>();

    /**
     *
     * @param nums 包含相同元素的整数数组
     * @return 所有不重复子集的集合
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subset));

        for(int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            backTracing(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
