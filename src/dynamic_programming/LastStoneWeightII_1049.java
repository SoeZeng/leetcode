package dynamic_programming;

import java.util.Scanner;

public class LastStoneWeightII_1049 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] stones = new int[arr.length];
            for (int i = 0; i < stones.length; i++) {
                stones[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.lastStoneWeightII(stones);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
         *
         * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x <= y。那么粉碎的可能结果如下：
         *
         * 如果x == y，那么两块石头都会被完全粉碎；
         * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
         * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
         *
         * @param stones
         * @return
         */
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for(int stone : stones) sum += stone;

            int capacity = sum >> 1;
            int[] dp = new int[capacity + 1];

            for(int i = 0; i < stones.length; i++) {
                for(int j = capacity; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }

            return sum - 2 * dp[capacity];
        }
    }
}
