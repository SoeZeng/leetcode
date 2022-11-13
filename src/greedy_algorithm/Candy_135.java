package greedy_algorithm;

import java.util.Scanner;

public class Candy_135 {
    public static void main(String[] args) {
        Solution135 sol = new Solution135();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] ratings = new int[arr.length];
            for(int i = 0; i < ratings.length; i++) {
                ratings[i] = Integer.parseInt(arr[i]);
            }
            int res = sol.candy(ratings);
            System.out.println(res);
        }
    }


}


class Solution135 {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * 你需要按照以下要求，给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        // 从前往后
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }else {
                candies[i] = 1;
            }
        }

        // 从后往前
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                // 取最大值才能保证糖果值既大于左边孩子的又大于右边孩子的
                candies[i] = Math.max(candies[i],candies[i + 1] + 1);
            }
        }

        int ans = 0;
        for(int i = 0; i < candies.length; i++) {
            ans += candies[i];
        }
        return ans;
    }

    public int candy1(int[] ratings) {
        int candyPre = 1; // 记录前一个孩子的糖果数量
        int candySum = 1;
        int ratingDown = 0; // 记录评分连续下降的数目(不包括当前评分)
        int candyTemp = 1; // 记录评分开始下降时第一个孩子的糖果数量
        for(int i = 1; i < ratings.length; i++) {
            candySum += 1;
            if(i > 0 && ratings[i] < ratings[i - 1]) {
                ratingDown++;
                candyTemp = Math.max(candyTemp,candyPre);
                // System.out.println(candyTemp);
                if(ratingDown < candyTemp) {
                    candySum += ratingDown - 1;
                }else {
                    candySum += ratingDown;
                }
                candyPre = 1;
            } else if(i > 0 && ratings[i] > ratings[i - 1]) {
                ratingDown = 0;
                candySum += candyPre;
                candyPre++;
                candyTemp = candyPre;
            } else {
                ratingDown = 0;
                candyPre = 1;
                candyTemp = 1;
            }
        }
        return candySum;
    }
}
