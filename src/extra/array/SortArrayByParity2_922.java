package extra.array;

import java.util.Scanner;

public class SortArrayByParity2_922 {

    public static void main(String[] args) {
        Solution922 sol = new Solution922();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String[] strs = s.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] ans = sol.sortArrayByParityII(nums);
            System.out.print("[");
            for (int i = 0; i < nums.length - 1; i++) {
                System.out.print(nums[i] + ",");
            }
            System.out.println(nums[nums.length - 1] + "]");
        }
    }
}

class Solution922 {

    /**
     * 给定一个非负整数数组nums，nums 中一半整数是 奇数 ，一半整数是 偶数 。
     *
     * 对数组进行排序，以便当nums[i] 为奇数时，i也是 奇数 ；当nums[i]为偶数时， i 也是 偶数 。
     *
     * 你可以返回 任何满足上述条件的数组作为答案 。
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {

        int len = nums.length;
        int[] ans = new int[len];
        int evenIndex = 0;
        int oddIndex = 1;
        for(int i = 0; i < len; i++) {
            if(nums[i] % 2 == 0) {
                ans[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                ans[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }

        return ans;


        // 不使用额外空间
//            int oddIndex = 1;
//            for(int i = 0; i < len; i += 2) {
//                if(nums[i] % 2 != 0) {
//                    while(nums[oddIndex] % 2 != 0) oddIndex += 2;
//                    int temp = nums[i];
//                    nums[i] = nums[oddIndex];
//                    nums[oddIndex] = temp;
//                }
//            }
//
//            return nums;
    }
}
