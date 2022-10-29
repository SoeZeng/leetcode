package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_40 {

    public static void main(String[] args) {

    }
}

class Solution40 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;

    /**
     *
     * @param candidates 有重复元素 的整数数组
     * @param target 目标整数
     * @return 使数字和为目标数 target 的 所有不同组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backTracing(candidates, target, 0, 0);
        return ans;
    }

    public void backTracing(int[] candidates, int target, int sum, int startIndex) {
        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 使用startIndex去重
//            if(i > startIndex && candidates[i] == candidates[i - 1]) continue;
//            path.add(candidates[i]);
//            backTracing(candidates, target, sum + candidates[i], i + 1);
//            path.remove(path.size() - 1);

            // 使用标记数组used去重
            if(i > 0 && candidates[i] == candidates[i -1] && used[i - 1] == false) continue;

            path.add(candidates[i]);
            used[i] = true;
            backTracing(candidates, target, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
            used[i] = false;


        }
    }
}
