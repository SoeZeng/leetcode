package 剑指offer;

import java.util.Scanner;

public class IntegerDivide {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = sol.divide(a, b);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，
         * 要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'
         *
         * @param a
         * @param b
         * @return
         */
        public int divide(int a, int b) {
            if(a == 0) return 0;
            if(b == 1) return a;
            if(a == b) return 1;
            if(b == -2147483648) return 0;
            if(a == -2147483648 && b == -1) return 2147483647;

            int ans = 0;
            int sign = 1;
            if(a < 0) {
                sign--;
                if(a == -2147483648) {
                    a += Math.abs(b); // 被除数为Integer.MIN_VALUE,做一下加分再用abs()的方法
                    ans++;
                }
                a = Math.abs(a);
            }
            if(b < 0) {
                sign--;
                b = Math.abs(b);
            }

            while(a >= b) {
                a -= b;
                ans++;
            }

            return sign == 0 ? -ans : ans;
        }
    }
}
