package extra.backtracking;

import java.util.Scanner;

public class NQueens2_52 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            Solution sol = new Solution();
            int res = sol.totalNQueens(n);
            System.out.println(res);
        }
    }
}

class Solution {
    int cnt = 0;

    /**
     * n皇后问题 研究的是如何将 n个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        char[][] chessboard = new char[n][n];
//            for(int i = 0; i < n; i++) {
//                Arrays.fill(chessboard[i],'.');
//            }
        backTracing(n, 0, chessboard);
        return cnt;
    }

    public void backTracing(int n, int row, char[][] chessboard) {
        if(row == n) {
            cnt++;
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isValid(row, col, chessboard, n)) {
                chessboard[row][col] = 'Q';
                backTracing(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }

        }
    }

    public boolean isValid(int row, int col, char[][] chessboard, int n) {

        // 检查列
        for(int i = 0; i < row; i++) {
            if(chessboard[i][col] == 'Q') return false;
        }

        // 检查45度角
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessboard[i][j] == 'Q') return false;
        }

        // // 检查135度角
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(chessboard[i][j] == 'Q') return false;
        }

        return true;

    }
}
