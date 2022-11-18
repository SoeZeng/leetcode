package dynamic_programming;

import java.util.Scanner;

public class FibonacciNumber_509 {

    public static void main(String[] args) {
        Solution509 sol = new Solution509();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int fib = sol.fib(n);
            System.out.println(fib);
        }
    }

}

class Solution509 {

//         public int fib(int n) {
//             if(n <= 1) return n;
//             return fib(n-1) + fib(n-2);
//         }

    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
     * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n <= 1) return n;
        // 1.确定dp数组以及下标的含义: 第i个数的斐波那契数值是dp[i]
        int[] dp = new int[n + 1];

        // 2.确定递推公式: dp[i] = dp[i - 1] + dp[i - 2]
        // 3.dp数组如何初始化
        dp[0] = 0;
        dp[1] = 1;
        // 4.确定遍历顺序：从前到后遍历
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 5.举例推导dp数组: n = 10时，dp数组应该是如下的数列：0 1 1 2 3 5 8 13 21 34 55

        return dp[n];

    }
}
