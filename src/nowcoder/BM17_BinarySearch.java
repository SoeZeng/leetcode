package nowcoder;

public class BM17_BinarySearch {

}

class Solution_BM17 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        if(nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return -1;

        int left = 0, right = nums.length - 1;
        int mid = (right - left) / 2 + left;

        while(mid >= 0 && mid < nums.length && left <= right) {
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
            mid = (right - left) / 2 + left;
        }

        return -1;
    }
}
