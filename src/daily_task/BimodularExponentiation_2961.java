package daily_task;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * 如果满足以下公式，则下标 i 是 好下标：
 * 0 <= i < variables.length
 * ((ai^bi % 10)^ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 */
public class BimodularExponentiation_2961 {

}

class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {

        // 暴力破解--数据溢出
//        List<Integer> res = new ArrayList<>();
//
//        int k = 0;
//        for(int[] v : variables) {
//            if(Math.pow(Math.pow(v[0], v[1]) % 10, v[2]) % v[3] == target) {
//                res.add(k);
//            }
//            k++;
//        }
//
//        return res;

        // 快速幂
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if(pow(pow(v[0], v[1], 10), v[2], v[3]) == target) res.add(i);
        }
        return res;
    }

    private int pow(int x, int n, int m) {
        int ans = 1;

        while(n > 0) {
            if((n & 1) == 1) {
                ans = ans * x % m;
            }
            x = x * x % m;
            n >>= 1;
        }

        return ans;
    }
}
