package backtracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationsSum3_216 {

    public static void main(String[] args) {

    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        /**
         * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
         *
         * 只使用数字1到9
         * 每个数字最多使用一次
         * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
         *
         * @param k
         * @param n
         * @return
         */
        public List<List<Integer>> combinationSum3(int k, int n) {
            backTracing(k,n,0,1);
            return ans;
        }

        public void backTracing(int k, int n, int sum, int startIndex) {
            if(path.size() == k) {
                if(sum == n) ans.add(new ArrayList<>(path));
                return;
            }

            for(int i = startIndex; i <= 9 && i + sum <= n; i++) {
                path.add(i);
                backTracing(k, n, sum + i, i + 1);
                path.removeLast();
            }
        }
    }
}
