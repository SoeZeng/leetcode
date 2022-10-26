package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Combinations_77 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            int k = Integer.parseInt(in.nextLine());
            Solution77 sol = new Solution77();
            sol.combine(n, k)
        }
    }
}

class Solution77 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *
     * @param n
     * @param k
     * @return 范围 [1, n] 中所有可能的 k 个数的组合
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
        // 已经选择的元素个数：path.size()
        // 还需要的元素个数：k - path.size()
        // 在集合n中至多从 n - (k - path.size()) + 1 开始遍历
        for(int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracing(n, k, i + 1);
            path.removeLast();
        }
    }
}
