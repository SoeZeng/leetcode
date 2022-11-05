package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations_47 {

    public static void main(String[] args) {

    }
}

class Solution47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    int[] used;

    /**
     *
     * @param nums 含重复数字的整型数组
     * @return 全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        used = new int[nums.length];
        Arrays.sort(nums);
        backTracing(nums);
        return result;
    }

    public void backTracing(int[] nums) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)) {
                continue;
            }

            used[i] = 1;
            path.add(nums[i]);
            backTracing(nums);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
