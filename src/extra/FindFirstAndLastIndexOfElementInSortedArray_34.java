package extra;

import java.util.Scanner;

public class FindFirstAndLastIndexOfElementInSortedArray_34 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            int target = Integer.parseInt(in.nextLine());
            String[] strs = s.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] ans = sol.searchRange(nums, target);
            System.out.println("[" + ans[0] + "," + ans[1] + "]");
        }
    }

    static class Solution {

        /**
         * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
         *
         * 如果数组中不存在目标值 target，返回[-1, -1]。
         *
         * @param nums 给定数组
         * @param target 目标值
         * @return 目标值在数组中的第一个位置和最后一个位置
         */
        public int[] searchRange(int[] nums, int target) {

            // 二分查找
            int start = 0;
            int end = nums.length - 1;
            int index = -1;
            while(start <= end) {
                int mid = start + (int)((end - start) / 2);
                if(nums[mid] == target) {
                    index = mid;
                    break;
                }
                else if(nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if(index == -1) return new int[]{-1,-1};

            int[] ans = new int[]{index,index};

            for(int i = index - 1; i >= 0; i--) {
                if(nums[i] == target) ans[0] = i;
                else break;
            }

            for(int i = index + 1; i < nums.length; i++) {
                if(nums[i] == target) ans[1] = i;
                else break;
            }

            return ans;
        }
    }
}
