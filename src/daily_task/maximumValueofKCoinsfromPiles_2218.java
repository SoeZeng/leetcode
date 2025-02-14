package daily_task;

import java.util.Arrays;
import java.util.List;

/**
 * 一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 *
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 *
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。同时给你一个正整数 k ，
 * 请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 */
public class maximumValueofKCoinsfromPiles_2218 {

}

class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
//        int ans = 0;
//
//        if(piles.size() == 1) {
//            for (int i = 0; i < k; i++) {
//                ans += piles.get(0).get(i);
//            }
//            return ans;
//        }
//
//        int[][] dp = new int[piles.size()][k];
//
//
//        return ans;

        int n = piles.size();
        int[][] memo = new int[n][k + 1];
        return dfs(n - 1, k, piles, memo);

    }

    private int dfs(int i, int j, List<List<Integer>> piles, int[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != 0) { // 之前计算过
            return memo[i][j];
        }
        // 不选这一组中的任何物品
        int res = dfs(i - 1, j, piles, memo);
        // 枚举选哪个
        int v = 0;
        for (int w = 0; w < Math.min(j, piles.get(i).size()); w++) {
            v += piles.get(i).get(w);
            // w 从 0 开始，物品体积为 w+1
            res = Math.max(res, dfs(i - 1, j - w - 1, piles, memo) + v);
        }
        return memo[i][j] = res;
    }

}