package nowcoder;

public class BM19_FindPeakElement {

}
class Solution_BM19 {
    public int findPeakElement (int[] nums) {
        // write code here
        if(nums.length == 1 || nums[0] > nums[1] ) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }

        return -1;

    }
}
