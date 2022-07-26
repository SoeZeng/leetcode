package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {

    public static void main(String[] args) {

    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        /**
         * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
         *
         * @param n
         * @param k
         * @return
         */
        public List<List<Integer>> combine(int n, int k) {
            backTracing(n,k,1);
            return ans;
        }

        public void backTracing(int n, int k, int startIndex) {
            if(path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }

//            for(int i = startIndex; i <= n; i++) {
//                path.add(i);
//                backTracing(n, k, i + 1);
//                path.removeLast();
//            }

            // 剪枝
            for(int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                backTracing(n, k, i + 1);
                path.removeLast();
            }
        }
    }
}
