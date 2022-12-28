package extra.array;

import java.util.Scanner;

public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        Solution35 sol = new Solution35();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int target = Integer.parseInt(in.nextLine());
            String[] strs = s.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int ans = sol.searchInsert(nums,target);
            System.out.println(ans);
        }
    }
}

class Solution35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

//            while(start <= end) {
        while(start < end) {
            int mid = start + (int)((end - start) / 2);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

//            return target > nums[start] ? start + 1 : start;
        return end + 1;
    }
}
