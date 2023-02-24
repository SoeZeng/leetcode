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

        // Heap Sort 构建大顶堆或小顶堆，将堆顶元素与堆尾元素交换后再调整

        // 构建大顶堆，从最后一个非叶子节点开始，从下至上，从右至左
//        for(int i = nums.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(nums, i, nums.length);
//        }
//
//        // 排序 交换+调整
//        for(int i = nums.length - 1; i >= nums.length - k; i--) {
//            int temp = nums[0];
//            nums[0] = nums[i];
//            nums[i] = temp;
//            adjustHeap(nums, 0, i);
//        }


        // Radix Sort 按位数进行排序，借助桶bucket进行分配与收集：没有考虑到负数
//        int max = 0;
//        for(int num : nums) {
//            max = Math.max(num, max);
//        }
//
//        int bitCount = (max + "").length();
//        int pow = 1;
//        for(int i = 0; i < bitCount; i++) {
//            // 分配
//            int[][] bucket = new int[10][n];
//            int[] bucketCount = new int[10]; //用于统计该桶中元素的数量
//            for(int num : nums) {
//                int idx = (num / pow) % 10;
//                bucket[idx][bucketCount[idx]++] = num;
//            }
//            pow *= 10;
//
//            // 收集
//            int t = 0;
//            for(int j = 0; j < 10; j++) {
//                while(bucketCount[j] != 0) {
//                    nums[t++] = bucket[j][--bucketCount[j]];
//                }
//            }
//
//        }


        // merge sort
        mergeSort(nums, 0, n - 1);


//        Arrays.sort(nums);

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


    public void adjustHeap(int[] nums, int pos, int n) {
        int temp = nums[pos];
        for(int i = 2 * pos + 1; i < n; i = 2 * i + 1) {
            if(i + 1 < n && nums[i + 1] > nums[i]) {
                i++;
            }
            if(nums[i] > temp) {
                nums[pos] = nums[i];
                pos = i;
            } else {
                break;
            }
        }
        nums[pos] = temp;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return;

        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int temp[] = new int[right - left + 1];
        int t = 0;

        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while(i <= mid) temp[t++] = nums[i++];
        while(j <= right) temp[t++] = nums[j++];

        t = 0;
        while(left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
