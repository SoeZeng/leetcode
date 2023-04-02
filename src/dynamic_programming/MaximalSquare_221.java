package dynamic_programming;

public class MaximalSquare_221 {

    public static void main(String[] args) {

    }
}

class Solution221 {

    /**
     *
     * @param matrix 二维矩阵
     * @return 最大正方形面积
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    max = Math.max(max, dp[i + 1][j + 1] * dp[i + 1][j + 1]);
                }
            }
        }

        return max;
    }
}
