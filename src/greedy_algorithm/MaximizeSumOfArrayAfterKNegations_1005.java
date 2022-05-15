package greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizeSumOfArrayAfterKNegations_1005 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int k = in.nextInt();
            int ans = sol.largestSumAfterKNegations(nums, k);
            System.out.println(ans);
        }
    }


    static class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int minValue = 101; // 记录最小值
            int sum = 0; // 记录最大和
            // 从前向后遍历，遇到负数将其变为正数，同时K--
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < 0 && k > 0) {
                    nums[i] *= -1;
                    k--;
                }
                minValue = Math.min(minValue,nums[i]);
                sum += nums[i];
            }
            // 如果K还大于0，那么最大和减去2倍最小值
            if(k % 2 == 1) {
                sum -= minValue * 2;
            }
            return sum;
        }

        public int largestSumAfterKNegations1(int[] nums, int k) {
            Arrays.sort(nums);

            // 方法一
            // int minIndex = -1; // 记录最小数所在下标
            // int index = 0;
            // int ans = 0;
            // for(int i = 0; i < k; i++) {
            //     if(minIndex > 0) {
            //         nums[minIndex] = - nums[minIndex];
            //     }
            //     else{
            //         if(nums[index] < 0) {
            //             nums[index] = -nums[index];
            //             if(index < nums.length - 1) index++;
            //         } else {
            //             if(index > 0 && nums[index] <= nums[index - 1] || index == 0) {
            //                 nums[index] = -nums[index];
            //             } else if(index > 0 && nums[index] > nums[index - 1]) {
            //                 nums[index - 1] = - nums[index - 1];
            //                 index--;
            //             }
            //             minIndex = index;
            //         }
            //     }
            // }

            // 方法二
            int index = 0; // 当前下标
            int minIndex = 0; //最小值下标
            int ans = 0;
            for(int i = 0; i < k; i++) {
                if(index == minIndex) {
                    nums[index] = -nums[index];
                    if(index < nums.length - 1 && nums[index] > nums[index + 1]) {
                        minIndex = ++index;
                    }
                }
            }
            for(int i = 0; i < nums.length; i++) {
                ans += nums[i];
            }
            return ans;
        }
    }
}
