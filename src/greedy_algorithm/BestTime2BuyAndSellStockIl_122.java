package greedy_algorithm;

public class BestTime2BuyAndSellStockIl_122 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = sol.maxProfit(prices);
        System.out.println(res);
    }

    static class Solution {
        /**
         * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
         *
         * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
         *
         * 返回 你能获得的 最大 利润。
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {

            // 假设在同一天购买并售出，利润为0
            int buy = 0;
            int sell = 0;
            int res = 0;
            for(int i = 1; i < prices.length; i++) {

                if(prices[i] <= prices[sell]) {
                    buy = i;
                    sell = buy;

                } else if(prices[i] - prices[buy] >= res + prices[i] - prices[sell]){
                    res = prices[i] - prices[buy];
                    sell = i;
                } else {
                    res += prices[i] - prices[sell];
                    buy = i;
                    sell = buy;
                }
            }
            return res;
        }


        public int maxProfit1(int[] prices) {
            // 根据题目的意思，当天卖出以后，当天还可以买入!!!!!!
            // 把利润分解为每天为单位的维度
            // 局部最优：收集每天的正利润，全局最优：求得最大利润。
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                result += Math.max(prices[i] - prices[i - 1], 0);
            }
            return result;
        }
    }

}


