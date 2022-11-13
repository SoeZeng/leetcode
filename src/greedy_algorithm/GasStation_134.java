package greedy_algorithm;

import java.util.Scanner;

public class GasStation_134 {

    public static void main(String[] args) {
        Solution134 sol = new Solution134();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            String[] arr1 = str1.split(",");
            String[] arr2 = str2.split(",");
            int[] gas = new int[arr1.length];
            int[] cost = new int[arr2.length];
            for(int i = 0; i < gas.length; i++) {
                gas[i] = Integer.parseInt(arr1[i]);
                cost[i] = Integer.parseInt(arr2[i]);
            }
            int ans = sol.canCompleteCircuit(gas, cost);
            System.out.println(ans);
        }
    }

}

class Solution134 {

    /**
     * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // // 直接从全局进行贪心选择
        // int minValue = 0;
        // int curSum = 0;
        // for(int i = 0; i < cost.length; i++) {
        //     curSum += gas[i] - cost[i];
        //     minValue = Math.min(minValue, curSum);
        // }
        // //情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
        // if(curSum < 0) return -1;

        // //情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出
        // //现负数，说明从0出发，油就没有断过，那么0就是起点。
        // if(minValue >= 0) return 0;

        // //情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能
        // //把这个负数填平的节点就是出发节点
        // for(int i = cost.length - 1; i >= 0; i--) {
        //     int rest = gas[i] - cost[i];
        //     minValue += rest;
        //     if(minValue >= 0) {
        //         return i;
        //     }
        // }
        // return -1;

        // 起始点将当前路径分为A、B两部分。其中，必然有(1)A部分剩余油量<0。(2)B部分剩余油量>0。
        // 所以，无论多少个站，都可以抽象为两个站点（A、B）。(1)从B站加满油出发，(2)开往A站，车加油，(3)再开回B站的过程。
        // 重点：B剩余的油>=A缺少的总油。必然可以推出，B剩余的油>=A站点的每个子站点缺少的油。
        int start = 0;
        int curSum = 0;
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {

        // 暴力算法：超出时间限制
        // for (int i = 0; i < cost.length; i++) {
        //     int rest = gas[i] - cost[i]; // 记录剩余油量
        //     int index = (i + 1) % cost.length;
        //     while (rest > 0 && index != i) { // 模拟以i为起点行驶一圈
        //         rest += gas[index] - cost[index];
        //         index = (index + 1) % cost.length;
        //     }
        //     // 如果以i为起点跑一圈，剩余油量>=0，返回该起始位置
        //     if (rest >= 0 && index == i) return i;
        // }
        // return -1;


        if (gas.length == 1 && gas[0] >= cost[0]) return 0;
        int curGas = 0;
        int ans = -1;
        for (int i = 0; i < gas.length; i++) {
            curGas = gas[i] - cost[i];
            if (curGas <= 0) continue;
            for (int j = i + 1; j < gas.length; j++) {
                curGas += gas[j] - cost[j];
                if (curGas < 0) break;
            }
            if (curGas >= 0) {
                for (int j = 0; j < i; j++) {
                    curGas += gas[j] - cost[j];
                    if (curGas < 0) break;
                }
                if (curGas >= 0) ans = i;
            }
        }
        return ans;

    }
}
