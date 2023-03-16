package array;

public class SearchA2DMatrix2_240 {
    public static void main(String[] args) {

    }
}

class Solution240 {
    /**
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(matrix[i][j] == target) return true;
        //     }
        // }

        // 从右上角看该矩阵为二叉搜索树
        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0) {
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
