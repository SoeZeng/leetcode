package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {

    public static void main(String[] args) {

    }
}

class Solution46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
//    int[] used = new int[21];
    int[] used;
    /**
     *
     * @param nums 不含重复数字的整型数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {

        used = new int[nums.length];
        backTracing(nums);
        return result;

    }

    public void backTracing(int[] nums) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

//        for(int i = 0; i < nums.length; i++) {
//            if(used[nums[i] + 10] == 1) continue;
//            used[nums[i] + 10] = 1;
//            path.add(nums[i]);
//            backTracing(nums);
//            path.remove(path.size() - 1);
//            used[nums[i] + 10] = 0;
//        }

//        for(int i = 0; i < nums.length; i++) {
//            if(used[i] == 1) continue;
//            used[i] = 1;
//            path.add(nums[i]);
//            backTracing(nums);
//            path.remove(path.size() - 1);
//            used[i] = 0;
//        }


        for(int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) continue;

            path.add(nums[i]);
            backTracing(nums);
            path.remove(path.size() - 1);

        }
    }
}
