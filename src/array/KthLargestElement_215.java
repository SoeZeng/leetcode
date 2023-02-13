package array;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElement_215 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String[] strArray = in.nextLine().split(" ");
            int[] nums = new int[strArray.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strArray[i]);
            }
            Solution215 sol = new Solution215();
            int k = in.nextInt();
            int kthLargest = sol.findKthLargest(nums, k);
            System.out.println(kthLargest);

        }

    }
}

class Solution215 {

    /**
     *
     * @param nums 整数数组
     * @param k 整数k
     * @return 第k个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
