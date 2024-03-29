package dynamic_programming;

import java.util.Scanner;

public class UniquePathsWithⅡ_63 {

    public static void main(String[] args) {
        Solution63 sol = new Solution63();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int m = Integer.parseInt(in.nextLine());
            int n = Integer.parseInt(in.nextLine());
            int[][] obstacleGrid = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s = in.nextLine();
                String[] arr = s.split(",");
                for (int j = 0; j < n; j++) {
                    obstacleGrid[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int ans = sol.uniquePathsWithObstacles(obstacleGrid);
            System.out.println(ans);
        }
    }
}

class Solution63 {
    /**
     * 一个机器人位于一个m x n网格的左上角。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

//        for(int i = 0; i < m; i++) {
//            if(obstacleGrid[i][0] == 1) break;
//            dp[i][0] = 1;
//        }
//
//        for(int j = 0; j < n; j++) {
//            if(obstacleGrid[0][j] == 1) break;
//            dp[0][j] = 1;
//        }

        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
