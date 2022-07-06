package array;

import java.util.Scanner;

public class RemoveElement_27 {

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
            int val = Integer.parseInt(in.nextLine());
            int ans = sol.removeElement(nums, val);
            System.out.println(ans);
        }
    }

    static class Solution {

        /**
         * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
         *
         * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
         *
         * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
         *
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = 0;

            for(; right < nums.length; right++) {
                if(nums[right] != val) nums[left++] = nums[right];
            }

            return left;
        }
    }
}
