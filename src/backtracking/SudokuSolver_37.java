package backtracking;

public class SudokuSolver_37 {

    public static void main(String[] args) {

    }
}

class Solution37 {
    // char[][] newBoard = new char[9][9];

    /**
     *
     * @param board 二维数组
     */
    public void solveSudoku(char[][] board) {
        // char[][] newBoard = new char[9][9];
        // for(int i = 0; i < 9; i++) {
        //     newBoard[i] = Arrays.copyOf(board[i]);
        // }
        backTracking(board);
    }

    public boolean backTracking(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;

                for(char k = '1'; k <= '9'; k++) {
                    if(isValid(k, i, j, board)) {
                        board[i][j] = k;
                        if(backTracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                return false;
            }
        }

        return true;
    }

    public boolean isValid(char key, int row, int col, char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == key || board[row][i] == key) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == key) {
                    return false;
                }
            }
        }

        return true;
    }
}
