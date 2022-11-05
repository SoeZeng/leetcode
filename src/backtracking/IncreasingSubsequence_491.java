package backtracking;

import test.Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingSubsequence_491 {

    public static void main(String[] args) {

    }
}

class Solution491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {
        // wrong test: [1,2,3,1,1,1,1]
        // if(path.size() >= 2) {
        //     result.add(new ArrayList<>(path));
        //     // return;
        // }

        // for(int i = startIndex; i < nums.length; i++) {
        //     if(i > startIndex && nums[i] == nums[i - 1]) {
        //         continue;
        //     }

        //     if(path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
        //         path.add(nums[i]);
        //         backTracing(nums, i + 1);
        //         path.remove(path.size() - 1);
        //     }
        // }

        if(path.size() > 1) {
            result.add(new ArrayList<>(path));
            // return;
        }

        int[] used = new int[201];
        for(int i = startIndex; i < nums.length; i++) {
            if(used[nums[i] + 100] == 1) {
                continue;
            }

            if(path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                used[nums[i] + 100] = 1;
                path.add(nums[i]);
                backTracing(nums, i + 1);
                path.remove(path.size() - 1);
            }

        }
    }
}
