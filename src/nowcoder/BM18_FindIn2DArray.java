package nowcoder;

public class BM18_FindIn2DArray {

}

class Solution_BM18 {
    public boolean Find (int target, int[][] array) {
        // write code here
        int rowCount = array.length;
        int colCount = array[0].length;
        int i, j;
        for(i = rowCount - 1, j = 0; i >= 0 && j < colCount;)
        {
            if(target == array[i][j])
                return true;
            else if(target < array[i][j]) i--;
            else j++;
        }

        return false;
    }
}
