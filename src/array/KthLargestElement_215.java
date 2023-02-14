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
        int n = nums.length;

        // Bubble Sort: TimeOut
        // for(int i = n - 1; i >= 0; i--) {
        //     for(int j = 0; j < i; j++) {
        //         if(nums[j] > nums[j + 1]) {
        //             int temp = nums[j];
        //             nums[j] = nums[j + 1];
        //             nums[j + 1] = temp;
        //         }
        //     }
        // }

        // Selected Sort: TimeOut
        // for(int i = 0; i < n; i++) {
        //     int min = i;
        //     for(int j = i + 1; j < n; j++) {
        //         if(nums[j] < nums[min]) {
        //             min = j;
        //         }
        //     }
        //     int temp = nums[i];
        //     nums[i] = nums[min];
        //     nums[min] = temp;
        // }


        // Quick Sort
        // quickSort(nums, 0, n - 1);

        Arrays.sort(nums);

        return nums[n - k];

    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;

        int left = start;
        int right = end;
        int k = nums[left];

        while(left < right) {
            while(left < right && nums[right] >= k) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= k) left++;
            nums[right] = nums[left];
        }
        nums[left] = k;

        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);

    }
}
