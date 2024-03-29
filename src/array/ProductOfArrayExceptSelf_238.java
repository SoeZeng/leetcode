package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

}

class Solution238 {

    /**
     *
     * @param nums 整数数组
     * @return 除自身外数组中各数的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 空间复杂度O(n)
//        int[] left = new int[n];
//        int[] right = new int[n];
//
//        left[0] = 1;
//        right[n - 1] = 1;
//
//        for(int i = 1; i < n; i++) {
//            left[i] = left[i - 1] * nums[i - 1];
//            right[n - i - 1] = right[n - i] * nums[n - i];
//        }
//
//        for(int i = 0; i < n; i++) {
//            answer[i] = left[i] * right[i];
//        }



        // 空间复杂度O(1)
        Arrays.fill(answer, 1);

        int left = 1;
        int right = 1;

        for(int i = 0; i < n; i++) {
            answer[i] *= left;
            answer[n - i - 1] *= right;
            left *= nums[i];
            right *= nums[n - i - 1];
        }


        return answer;


    }
}
