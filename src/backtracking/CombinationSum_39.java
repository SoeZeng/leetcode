package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {

    }
}

class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    /**
     *
     * @param candidates 无重复元素 的整数数组
     * @param target 目标整数
     * @return 使数字和为目标数 target 的 所有不同组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0);
        return ans;
    }

    public void backTracing(int[] candidates, int target, int sum, int startIndex) {

        // if(sum > target) return;

        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backTracing(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
