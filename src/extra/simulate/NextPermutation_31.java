package extra.simulate;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation_31 {

    public static void main(String[] args) {
        Solution31 sol = new Solution31();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            sol.nextPermutation(nums);
            System.out.print("[");
            for (int i = 0; i < nums.length - 1; i++) {
                System.out.print(nums[i] + ",");
            }
            System.out.println(nums[nums.length - 1] + "]");

        }
    }

}

class Solution31 {

    /**
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
     * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列
     * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * @param nums 排列
     */
    public void nextPermutation(int[] nums) {

//        int n = nums.length;
//
//        for(int i = n - 1; i >= 0; i--) {
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] > nums[i]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    Arrays.sort(nums,i + 1, n);
//                    return;
//                }
//            }
//        }
//
//        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = nums.length - 1; j > i; j--) {
                if(nums[j] > nums[i]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1);
                    return;
                }
            }
        }

        reverse(nums, 0);

        return;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void reverse(int[] nums, int index) {
        for(int i = index, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}
