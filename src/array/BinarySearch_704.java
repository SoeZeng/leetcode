package array;

import java.util.Scanner;

public class BinarySearch_704 {

    public static void main(String[] args) {
        Solution704 sol = new Solution704();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int target = Integer.parseInt(in.nextLine());
            int ans = sol.search(nums, target);
            System.out.println(ans);
        }
    }
}

class Solution704 {

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
//            return binarySearch(nums, 0, nums.length - 1, target);
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) return -1;

        int mid = start + (end - start) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
