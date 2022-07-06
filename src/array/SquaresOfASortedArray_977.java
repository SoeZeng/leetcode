package array;

import java.util.Scanner;

public class SquaresOfASortedArray_977 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int[] res = sol.sortedSquares(nums);

        }
    }

    static class Solution {

        /**
         * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
         *
         * @param nums
         * @return
         */
        public int[] sortedSquares(int[] nums) {

//            int[] res = new int[nums.length];
//            int left = 0;
//            int right = 0;
//
//            while(right < nums.length && nums[right] < 0) right++;
//            left = right - 1;
//
//            for(int i = 0; i < nums.length; i++) {
//                if(left >= 0 && right < nums.length) {
//                    if(Math.abs(nums[left]) < Math.abs(nums[right])) {
//                        res[i] = nums[left] * nums[left];
//                        left--;
//                    } else {
//                        res[i] = nums[right] * nums[right];
//                        right++;
//                    }
//                } else if(left >= 0) {
//                    res[i] = nums[left] * nums[left];
//                    left--;
//                } else if(right < nums.length) {
//                    res[i] = nums[right] * nums[right];
//                    right++;
//                }
//            }
//
//            return res;

            int right = nums.length - 1;
            int left = 0;
            int[] result = new int[nums.length];
            int index = result.length - 1;
            while (left <= right) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    result[index--] = nums[left] * nums[left];
                    ++left;
                } else {
                    result[index--] = nums[right] * nums[right];
                    --right;
                }
            }
            return result;

        }
    }
}
