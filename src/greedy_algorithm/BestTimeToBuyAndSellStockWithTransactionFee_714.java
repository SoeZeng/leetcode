package greedy_algorithm;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {


    public static void main(String[] args) {
        Solution714 sol = new Solution714();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            int fee = in.nextInt();
            String[] arr = str.split(",");
            int[] prices = new int[arr.length];
            for(int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            int ans = sol.maxProfit(prices, fee);
            System.out.println(ans);
        }
    }
}

class Solution714 {
    /**
     * 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int minPrice = prices[0]; // 记录最低价格
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i]; // 买入
            } else if(prices[i] > minPrice + fee){
                profit += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee; // 持有股票，继续收获利润
            }
        }
        return profit;


//        int ans = 0;
//        int minValue = Integer.MAX_VALUE;
//
//        for(int i = 0; i < prices.length; i++) {
//
//            // 买入：当前价格小于最低价格
//            if(prices[i] < minValue) {
//                minValue = prices[i];
//            }
//
//            // 保持原状：当前价格大于等于最低价格且小于等于最低价格加上服务费的费用
//            if(prices[i] >= minValue && prices[i] <= minValue + fee) {
//                continue;
//            }
//
//            // 计算利润：可能有多次计算，但最后一次计算才是真正的卖出
//            if(prices[i] > minValue + fee) {
//                ans += prices[i] - (minValue + fee);
//
//                // 重新记录最低价格
//                minValue = prices[i] - fee;
//            }
//        }
//
//        return ans;
    }
}
