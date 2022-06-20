package extra;

import java.util.Scanner;

public class RotateArray_189 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int k = Integer.parseInt(in.nextLine());
            String[] strs = s.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            sol.rotate(nums,k);
            System.out.print("[");
            for (int i = 0; i < nums.length - 1; i++) {
                System.out.print(nums[i] + ",");
            }
            System.out.println(nums[nums.length - 1] + "]");
        }
    }

    static class Solution {

        /**
         * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
         *
         * @param nums 给定数组
         * @param k 向右轮转 k 个位置
         */
        public void rotate(int[] nums, int k) {

            /**
             * 方法一：复制数组后再轮转
             */
            int n = nums.length;
            int[] temp = new int[n];
            for(int i = 0; i < n; i++) {
                temp[i] = nums[i];
            }
            k = k % n;

            /**
             * 方法二：原地轮转
             */
            for(int i = 0; i < n; i++) {
                int index = (n - k + i) % n;
                nums[i] = temp[index];
            }

            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        public void reverse(int[] nums, int start, int end) {
//            while(start < end) {
//                nums[start] ^= nums[end];
//                nums[end] ^= nums[start];
//                nums[start] ^= nums[end];
//                start++;
//                end--;
//            }

            for (int i = start, j = end; i < j; i++, j--) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

    }
}
