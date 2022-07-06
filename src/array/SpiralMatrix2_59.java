package array;

import java.util.Scanner;

public class SpiralMatrix2_59 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[][] res = sol.generateMatrix(n);
        }
    }

    static class Solution {

        /**
         * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
         *
         * @param n
         * @return
         */
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int r = 0;
            int c = 0;
            int val = 1;

            for(int cur = 0; cur <= n / 2; cur++) {

                while(r == cur && c < n - cur) {
                    res[r][c++] = val++;
                }
                c--;
                r++;
                while(c == n - cur - 1 && r < n - cur) {
                    res[r++][c] = val++;
                }
                r--;
                c--;
                while(r == n - cur - 1 && c >= cur) {
                    res[r][c--] = val++;
                }
                c++;
                r--;
                while(c == cur && r > cur) {
                    res[r--][c] = val++;
                }
                r++;
                c++;
            }


            return res;
        }
    }
}
