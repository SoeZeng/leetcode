package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {

    }
}

class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new LinkedList<>();

    /**
     *
     * @param nums 元素互不相同的整数数组
     * @return 所有不重复子集的集合
     */
    public List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subset));

        for(int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backTracing(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
